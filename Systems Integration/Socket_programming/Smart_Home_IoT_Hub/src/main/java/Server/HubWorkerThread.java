package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HubWorkerThread implements Runnable{
    private final Socket server;
    private static int userCount;

    public HubWorkerThread(Socket server){
        this.server = server;
    }

    @Override
    public void run(){
        try {
            //writing from a user and writing to a user
            PrintWriter write = new PrintWriter(server.getOutputStream());
            Scanner read = new Scanner(server.getInputStream());

            //Identifying the connected user and sending a response to user
            userCount++;
            System.out.println("User: "+userCount+"\nId: "+server.getPort()+"\nConnected!");
            write.println("Successfully connected to server");
            write.flush();

            //Back and forth communication
            while (true) {
                //Send an object
                write.println("\nSelect a number from available device\n" +
                        "1 = tv \n" +
                        "2 = lights \n" +
                        "3 = fridge \n");
                write.flush();

                System.out.println("Selected option: "+read.nextLine());

                write.println("Test worked");
                write.flush();
            }

        } catch (IOException e) {
            System.out.println("Server Disconnected!");
            System.exit(1);
        }
    }
}