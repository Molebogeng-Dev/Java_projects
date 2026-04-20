package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SmartHubServer extends ValidCommands{
    static Socket serverPort;

    //To run the server first
    public void main(String[] args){
       try (ServerSocket port = new ServerSocket(7777)) {

           //starting server listening
           System.out.println("Server up and running...");
           while (true) {
               serverPort = port.accept();
               //server sending data to a connector

               new Thread(new HubWorkerThread(serverResponse(), serverPort)).start();
           }

       }
       catch (IOException e) {
           throw new RuntimeException("Server could not connect");
       }
    }


}
