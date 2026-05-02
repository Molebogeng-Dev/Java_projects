package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class SmartHubServer {
    public static void main(){
        //Server initialization
        try (ServerSocket server = new ServerSocket(5555)){

            //Server connected and listening
            System.out.println("Server up and running");
            Socket workingServer = server.accept();

            //Running a thread to process multiple commands from user
            while (true){ new HubWorkerThread(workingServer); }

        } catch (IOException e) {
            System.out.println("Server can not run!");
            System.exit(1);
        }
    }
}