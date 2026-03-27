package za.co.wethinkcode.toyrobot;

import za.co.wethinkcode.toyrobot.world.IWorld;

public class MazeRunCommand extends Command {
    public MazeRunCommand(String edge) {
        super("mazerun", edge);
    }

    @Override
    public boolean execute(Robot target) {
        String argument = getArgument();

        switch (argument){
            case "top":
                target.setPosition(new Position(0,200));
                target.setStatus("I am at the top edge. (Cost: 2 steps)");
                break;
            case "bottom":
                target.setPosition(new Position(0,-200));
                target.setStatus("I am at the bottom edge. (Cost: 2 steps)");
                break;
            case "right":
                target.setPosition(new Position(200,0));
                target.setStatus("I am at the right edge. (Cost: 2 steps)");
                break;
            case "left":
                target.setPosition(new Position(-200,0));
                target.setStatus("I am at the left edge. (Cost: 2 steps)");
                break;
        }
        return true;
    }
}
