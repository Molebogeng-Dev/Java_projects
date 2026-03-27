package za.co.wethinkcode.toyrobot;

import java.util.ArrayList;
import java.util.Collections;

public class ReplayCommand extends Command {
    @Override
    public boolean execute(Robot target) {
        String[] args = getArgument().trim().split(" ");
        ArrayList<Command> replayList = target.getCommands();
        int count = 0;

        if(args.length == 1){
            count = count + replayList.size();
            replayCommands(replayList, target);
        }else {
            boolean reversed = getArgument().contains("reversed");
            ArrayList<Command> commandSubset = getCommandSubset(args, replayList, target);
            if (reversed) {
                Collections.reverse(commandSubset);
            }
            count = count + commandSubset.size();
            replayCommands(commandSubset, target);
        }

        target.setStatus("replayed " +count+ " commands.");
        return true;
    }

    private void replayCommands(ArrayList<Command> replayList, Robot target) {
        for (Command command : replayList) {
            command.execute(target);
            System.out.println(target.toString());
        }
    }

    public static boolean isInteger(String arg) {
        try {
            Integer.parseInt(arg);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private ArrayList<Command> getCommandSubset(String[] args, ArrayList<Command> replayList, Robot target) {
        if (args.length == 2 && !args[1].contains("-")) {
            if (isInteger(args[1])){
                int numCommands = Integer.parseInt(args[1]);
                int startIndex = Math.max(replayList.size() - numCommands, 0);
                return new ArrayList<>(replayList.subList(startIndex, replayList.size()));
            } else{
                return new ArrayList<>(replayList);
            }
        } else if (args.length >= 2 ) {
            if (args.length >= 2 && args[1].contains("-")) {
                String[] subArgs = args[1].split("-");
                int n = Integer.parseInt(subArgs[0]);
                int m = Integer.parseInt(subArgs[1]);

                int startIndex = Math.max(replayList.size() - n, 0);
                int endIndex = Math.max(replayList.size() - m, 0);

                return new ArrayList<>(replayList.subList(0, 2));

            } else if (args.length == 3 && args[1].contains("reversed")){
                if (args[2].contains("-")){
                    String[] subArgs = args[2].split("-");
                    int n = Integer.parseInt(subArgs[0]);
                    int m = Integer.parseInt(subArgs[1]);
                    int startIndex = Math.max(replayList.size() - n, 0);
                    int endIndex = Math.max(replayList.size() - m, 0);

                    return new ArrayList<>(replayList.subList(0, 2));
                }else{
                    int numCommands = Integer.parseInt(args[2]);
                    int startIndex = Math.max(replayList.size() - numCommands, 0);
                    return new ArrayList<>(replayList.subList(startIndex, replayList.size()));
                }
            }
        }
        return new ArrayList<>(replayList);
    }

    private ArrayList<Command> parseRange(String range, Robot target) {
        ArrayList<Command> result = new ArrayList<>();
        String[] bounds = range.split("-");
        int start = Integer.parseInt(bounds[0]);
        int end = Integer.parseInt(bounds[1]);
        for (int i = start - 1; i < end && i < target.getCommands().size(); i++) {
            result.add(target.getCommands().get(i));
        }
        return result;
    }

    public ReplayCommand() {
        super("replay");
    }

    public ReplayCommand(String argument) {
        super("replay", argument);
    }


}