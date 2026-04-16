package Server;

public abstract class ValidCommands {

    // validating if the user input is valid or not
    public Boolean validator(String device, String status) {
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
        //System.out.println( "Percent does not have a value");
        if (!percent.contains("%")) {
            //System.out.println( "Percent does not contain a % sign");
            return false;
        }
        else{
            return percent.length() != 1;
        }
    }
}

