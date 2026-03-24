package za.co.wethinkcode.toyrobot;

public class ForwardCommand extends Command{
    public ForwardCommand() {
        super("forward");
    }

    public ForwardCommand(String argument){
        super("forward",argument);

    }
}
