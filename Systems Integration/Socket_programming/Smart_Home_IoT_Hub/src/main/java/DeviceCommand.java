public class DeviceCommand extends ValidCommands {
    private String device;
    private String percent;
    private String status;

    // constructors for assigning data to my instances
    public DeviceCommand(String device, String status){
        if( device.isBlank() || device.equals("") || status.equals("") ){
            throw new IllegalArgumentException( "Invaild Command: [].");
        }
            this.device = device;
            this.status = status;

    }

    public DeviceCommand(String device, String status, String percent){
        this(device,status);
        if (!validator(percent)){
            throw new IllegalArgumentException("Invalid percent format or length ");
        }
        this.percent = percent;
    }

    /*
    // This is the JSON message we are going to serialize
    @Override
    public String toString(){
        if ( percent.isBlank() || percent.isEmpty() || status.equalsIgnoreCase("off") ) {
            return "Device selected: " + device + " .The status of the device is: " + status + ".";
        }
        else {
            return "Device selected: " + device + " .The status of the device is: " + status + "to "+percent+".";
        }
    }*/


}