package Server;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HubWorkerThread extends ValidCommands implements Runnable{
    private Scanner receiver;
    private PrintWriter sender;
    private Socket server;


    public HubWorkerThread(Socket server) {
        this.server = server;
    }

    @Override
    public void run() {
        // Sending and receiving information from the server to client or vice versa
        try {
            //Set up the Speaker (Scanner) and Microphone (PrintWriter)
            this.receiver = new Scanner(server.getInputStream());
            this.sender = new PrintWriter(server.getOutputStream());

            //Read the raw JSON string from the client (The closed cardboard box)
            String incomingJson = this.receiver.nextLine();
            System.out.println("Hub received raw data: " + incomingJson);

            //Unpack the box using Gson!
            Gson gson = new Gson();
            DeviceCommand unpackedCommand = gson.fromJson(incomingJson, DeviceCommand.class);

            //Generate the reply.
            String reply = unpackedCommand.serverResponse();

            //Put the reply in the envelope and SEND IT (flush!)
            this.sender.println(reply);
            this.sender.flush();
        }
        catch (IOException e){
            System.out.println("Error: Server disconnected!");
        }

        this.receiver.close();
        this.sender.close();
    }

}
