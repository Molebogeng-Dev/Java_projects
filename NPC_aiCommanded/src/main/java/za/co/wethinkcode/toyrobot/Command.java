package za.co.wethinkcode.toyrobot;

import java.util.Locale;

public abstract class Command {
    private final String name;
    private String argument;

    public Command(String name){
        this.name = name.toLowerCase().trim();
    }

    public Command(String name, String argument) {
        this(name);
        this.argument = argument.trim();
    }

    public String getArgument() {
        return this.argument;
    }

    public String getName() {
        return name;
    }

    public static Command create(String instruction) {
        String[] args = instruction.toLowerCase().trim().split(" ");
        return switch (args[0]) {
            case "shutdown" -> new ShutdownCommand();
            case "help" -> new HelpCommand();
            case "forward" -> new ForwardCommand(args[1]);
            default -> throw new IllegalArgumentException("Unsupported command: " + instruction);
        };
    }

    public boolean execute(Robot target) {
        target.setStatus("...");
        return true;
    }
}
