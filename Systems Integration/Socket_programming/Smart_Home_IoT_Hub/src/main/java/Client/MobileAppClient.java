package Client;

import Server.HubWorkerThread;
import Server.DeviceCommand;
import Server.SmartHubServer;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.ArrayList;

public class MobileAppClient {

    public static void main(String[] args) throws IOException {
        //initializing a socket so it can send to server
        final Socket client = new Socket("127.0.0.1",8081);
        DeviceCommand commands = null;
        String response;
        Scanner command = new Scanner(System.in);
        ArrayList<String> responses = new ArrayList<>();


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

            //converting object to a json file to send it to server
            Gson json = new Gson();
            String jCommands = json.toJson(commands);

            //back and forth communication from the server and app
            new HubWorkerThread(jCommands, client);
            new SmartHubServer(commands.response());


            command.close();

    }
}


