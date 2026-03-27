package za.co.wethinkcode.toyrobot;

public class SprintCommand extends Command {
    public SprintCommand(String arg) {
        super("sprint",arg);
    }

    public boolean execute(Robot target) {
        int steps = Integer.parseInt(getArgument());

        for (int i = steps; i > 0; i--) {
            if (target.updatePosition(i)){
                target.setStatus("Moved forward by "+ i +" steps.");
            } else {
                target.setStatus("Sorry, I cannot go outside my safe zone.");
            }
            if (i != 1) {
                System.out.println(target);
            }
        }

        return true;
    }
}