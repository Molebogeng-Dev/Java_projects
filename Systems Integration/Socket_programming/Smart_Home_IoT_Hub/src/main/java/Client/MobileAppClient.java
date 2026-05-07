package Client;

import Server.backend.DeviceCommand;
import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.Scanner;
import java.util.stream.Stream;

public class MobileAppClient {

    static void main(@NotNull String[] args){
        int connected = 3;
        do {
            try (Socket user = new Socket("localhost", 5555)) {
                //Reading from a server and writing to a server
                Scanner read = new Scanner(user.getInputStream());
                PrintWriter send = new PrintWriter(user.getOutputStream());
                Gson json = new Gson();
                //Opening the App
                if (args[0].trim().equalsIgnoreCase("open") && args.length == 1) {
                    //Server's connection response.
                    String intro = read.nextLine();
                    if (intro.toLowerCase().contains("connected")) {
                        //while (response != null) {
                            System.out.println(intro);

                            //App start ,logic.
                            boolean status = false;

                            do{
                                // Json deserialization so I can use Tcp method (send all the relevant data at once
                                DeviceCommand commands = json.fromJson(read.nextLine() , DeviceCommand.class);
                                System.out.println( commands );

                                Scanner userInput = new Scanner(System.in);
                                userInput.nextLine();
                                for ( String select : new String[]{"1", "2", "3"}){
                                    if (userInput.equals(select)){
                                        send.println(userInput);
                                        status = true;
                                    }
                                    else {
                                        System.out.println("Incorrect command!");
                                    }
                                }
                            }while (!status);
                            System.out.println("Works");

                    } else {
                        connected--;
                        //the below can not be a response from server because it is not connected
                        System.out.println("Trying to reconnect to server");
                    }
                }
                else if (!args[0].trim().equalsIgnoreCase("close") && args.length != 1) {
                    System.out.println("""
                            Incorrect Commands
                            Available Commands:
                            Opening the app = open
                            Closing the app = close""");
                    System.exit(2);
                }
                //Closing the App
                //Response from Server saying closed
                closingConnection(read,send,user);
                System.exit(0);

            }
            catch (IOException e) {
                throw new RuntimeException();
            }
            catch (RuntimeException e){
                throw new RuntimeException("User could not connect to server");
            }
        } while (connected != 0);
        throw new RuntimeException();
        //If it fails to connect after the number of tries throw an error
    }

    //Closes all users memory usage
    private static void closingConnection(Scanner read, PrintWriter send, Socket user) throws IOException {
        read.close();
        send.close();
        user.close();
        System.exit(0);
    }
}