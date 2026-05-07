package Server;

import Server.backend.DeviceCommand;
import com.google.gson.Gson;

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
            Gson json = new Gson();

            //Identifying the connected user and sending a response to user
            userCount++;
            System.out.println("User: "+userCount+"\nId: "+server.getPort()+"\nConnected!");
            write.println("Successfully connected to server");
            write.flush();

            //Back and forth communication
            //while (true) {
                //Send an object
                // JSON Serialization so I can use Tcp method (send all the relevant data at once
                DeviceCommand obj = new DeviceCommand();
                String commands = json.toJson(obj);

                write.println(commands);
                write.flush();

                System.out.println("Selected option: "+read.nextInt());

                write.println("Test worked");
                write.flush();
            //}

        } catch (IOException e) {
            System.out.println("Server Disconnected!");
            System.exit(1);
        }
    }
}