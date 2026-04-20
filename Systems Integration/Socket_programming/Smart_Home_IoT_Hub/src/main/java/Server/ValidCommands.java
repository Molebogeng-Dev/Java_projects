package Server;

public abstract class ValidCommands  {

    private String device;
    private String status;
    private String percent = "Not applicable";

    // validating if the user input is valid or not
    public Boolean validator(String device, String status) {
        this.device = device;
        this.status = status;
        return switch (device.toLowerCase()) {
            case "tv", "doors", "windows", "fridge", "washing machine" -> switch (status.toLowerCase()) {
                case "on", "off" -> true;
                default -> false;
            };
            default -> false;
        };
    }

    // method overloading
    public Boolean validator(String percent) {
        this.percent = percent;
        //System.out.println( "Percent does not have a value");
        if (!percent.contains("%")) {
            //System.out.println( "Percent does not contain a % sign");
            return false;
        }
        else{
            return percent.length() != 1;
        }
    }

    //Response from server
    public String serverResponse(){
        if (this.validator(this.device,this.status) && this.validator(this.percent) && !this.percent.equals("Not applicable")){
            return "Device selected: " + device + " . The status of the device is: " + status + ". Percentage: "+percent+".";
        }
        else if (this.validator(this.device,this.status) && this.validator(this.percent)) {
            return "Device selected: " + device + " . The status of the device is: " + status + ".";
        }
        else {
            return "CAN NOT LOCATE THE FOLLOWING:\n Device selected: " + device + " . The status of the device is: " + status + ". Percentage: "+percent+".";
        }

    }
}

