package Server.backend;

public class DeviceCommand {

    public DeviceCommand(){}

    @Override
    public String toString(){
        return "\nSelect a number from available device\n" +
                "1 = tv \n" +
                "2 = lights \n" +
                "3 = fridge \n";

    }
}