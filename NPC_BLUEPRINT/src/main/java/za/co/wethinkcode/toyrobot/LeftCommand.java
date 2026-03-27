package za.co.wethinkcode.toyrobot;

public class LeftCommand extends Command {
    public LeftCommand() {
        super("left");
    }

    @Override
    public boolean execute(Robot target){
        switch (target.getCurrentDirection()){
            case NORTH:
                target.setCurrentDirection(Direction.WEST);
                break;
            case EAST:
                target.setCurrentDirection(Direction.NORTH);
                break;
            case SOUTH:
                target.setCurrentDirection(Direction.EAST);
                break;
        }
        target.setStatus("Turned left.");
        return true;
    }
}