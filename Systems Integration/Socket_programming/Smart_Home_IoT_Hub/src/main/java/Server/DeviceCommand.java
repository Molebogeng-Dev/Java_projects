package Server;

public class DeviceCommand extends ValidCommands {

    // constructors for assigning data to my instances
    public DeviceCommand(String device, String status){
        if( device.isBlank() || device.equals("") || status.equals("") ){
            throw new IllegalArgumentException( "Input can not be empty!");
        }
            validator(device,status);
    }

    public DeviceCommand(String device, String status, String percent){
        this(device,status);
        if (!validator(percent)){
            throw new IllegalArgumentException("Invalid percent format or length!");
        }
    }



}