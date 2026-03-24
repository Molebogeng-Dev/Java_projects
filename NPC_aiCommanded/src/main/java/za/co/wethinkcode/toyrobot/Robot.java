package za.co.wethinkcode.toyrobot;

import java.util.Arrays;
import java.util.List;

public class Robot {
    private static final List<String> VALID_COMMANDS = Arrays.asList("off", "help", "forward");

    private final Position TOP_LEFT = new Position(-100,200);
    private final Position BOTTOM_RIGHT = new Position(100,-200);

    public static final Position CENTRE = new Position(0,0);

    private Position position;
    private Direction currentDirection;
    private String status;
    private String name;

    public Robot(String name) {
        this.name = name;
        this.status = "Ready";
        this.currentDirection = Direction.NORTH;
    }

    public Position getPosition(){
        return this.position;
    }

    public String getStatus() {                                                                         //<5>
        return this.status;
    }

    public Direction getCurrentDirection() {                                                               //<8>
        return this.currentDirection;
    }

    public boolean handleCommand(Command command) {
        String commandName = command.getName();

        switch (commandName){
            case "off":
                this.status = "Shutting down";
                break;
            case "help":
                this.status = doHelp();
                break;
            case "forward":
                String argument = command.getArgument();
                this.status = doForward(Integer.parseInt(argument));
                break;
            default:
                this.status = "I am not programmed for: " + command.getName();
        }
        return true;
    }

    private String doHelp() {
        return "I can understand these commands:\n" +
                "OFF  - Shut down robot\n" +
                "HELP - provide information about commands\n" +
                "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'";
    }

    private boolean isPositionAllowed(int newX, int newY) {
        return TOP_LEFT.getX() <= newX && newX <= BOTTOM_RIGHT.getX()
                && BOTTOM_RIGHT.getY() <= newY && newY <= TOP_LEFT.getY();
    }

    private boolean updatePosition(int nrSteps){
        int newX = this.position.getX();
        int newY = this.position.getY();

        if(Direction.NORTH.equals(this.currentDirection)) {
            newY = newY + nrSteps;
        }

        Position newPosition = new Position(newX, newY);
        if (newPosition.isIn(TOP_LEFT,BOTTOM_RIGHT)){
            this.position = newPosition;
            return true;
        }
        return false;
    }

    private String doForward(int nrSteps){
        if (updatePosition(nrSteps)){
            return "Moved forward by "+nrSteps+" steps.";
        } else {
            return "Sorry, I cannot go outside my safe zone.";
        }
    }

    @Override
    public String toString() {
       return "[" + CENTRE.getX() + "," + CENTRE.getY() + "] "
               + "{" + this.currentDirection + "} "
               + this.name + "> " + this.status;
    }
}
