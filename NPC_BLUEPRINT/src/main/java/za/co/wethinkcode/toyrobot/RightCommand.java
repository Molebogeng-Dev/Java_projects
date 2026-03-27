package za.co.wethinkcode.toyrobot;

public class RightCommand extends Command {
    public RightCommand() {
        super("right");
    }

    @Override
    public boolean execute(Robot target){
        switch (target.getCurrentDirection()) {
            case NORTH:
                target.setCurrentDirection(Direction.EAST);
                break;
            case EAST:
                target.setCurrentDirection(Direction.SOUTH);
                break;
            case SOUTH:
                target.setCurrentDirection(Direction.WEST);
                break;
        }
        target.setStatus("Turned right.");
        return true;
    }
}