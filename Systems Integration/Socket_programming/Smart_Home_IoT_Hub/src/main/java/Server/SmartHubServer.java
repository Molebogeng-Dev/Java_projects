package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SmartHubServer{
    //To run the server first
    public static void main(String[] args){
       try (ServerSocket port = new ServerSocket(7777)) {

           //starting server listening
           System.out.println("Server up and running...");
           while (true) {
               //server sending data to a server connector
               new Thread(new HubWorkerThread( port.accept() ) ).start();
           }

       }
       catch (IOException e) {
           throw new RuntimeException("Server could not connect");
       }
    }

}
