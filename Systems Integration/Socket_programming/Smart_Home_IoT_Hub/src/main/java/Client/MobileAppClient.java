package Client;

import Server.DeviceCommand;
import com.google.gson.Gson;

import java.util.Scanner;
import java.util.ArrayList;

public class MobileAppClient {

    public static void main(String[] args){
        DeviceCommand commands = null;
        ArrayList<String> responses = new ArrayList<>();
        String response;
        Scanner command = new Scanner(System.in);

        //getting input from user
        for (String deviceCommand : new String[]{"device", "status", "percentage if applicable"}){
            System.out.print("Enter a "+deviceCommand+": ");
            response = command.nextLine();
            System.out.println(response);
            if(!deviceCommand.equals("percentage if applicable") || deviceCommand.equals("percentage if applicable") && deviceCommand.equalsIgnoreCase("")){
                responses.add(response);
            }
        }

        //creating objects so I can JSON serialize them
        if( responses.size() == 2){
            commands = new DeviceCommand(responses.getFirst(), responses.getLast() );
        }
        else if ( responses.size() == 3 ) {
             commands = new DeviceCommand(responses.get(0), responses.get(1), responses.get(2) );
        }




        command.close();
    }
}


