package Client;

import Server.DeviceCommand;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.ArrayList;

public class MobileAppClient {

    public static void main(String[] args){
        DeviceCommand commands = null;
        String response;
        Scanner command = new Scanner(System.in);
        ArrayList<String> responses = new ArrayList<>();

        try {
            //initializing a socket so it can send to server
            Socket app = new Socket("127.0.0.1", 8081);

            //getting input from user
            for (String deviceCommand : new String[]{"device", "status", "percentage if applicable"}) {

                if (deviceCommand.equals("percentage if applicable")){
                    System.out.println("\"Enter a " + deviceCommand + "(Or press enter if no value): ");
                }
                else {
                    System.out.print("Enter a " + deviceCommand + ": ");
                }
                response = command.nextLine();

                if (!response.equalsIgnoreCase("")) {
                    responses.add(response);
                }
            }

            //creating objects so I can JSON serialize them
            if (responses.size() == 2) {
                commands = new DeviceCommand(responses.getFirst(), responses.getLast());
            } else if (responses.size() == 3) {
                commands = new DeviceCommand(responses.get(0), responses.get(1), responses.get(2));
            }

            //back and forth communication from the server and app
            new Communicator(app,commands);


            command.close();
        } catch (IOException e) {
            System.out.println("App could not connect to server!");
        }
    }
}


