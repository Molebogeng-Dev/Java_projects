package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HubWorkerThread implements Runnable{
    private Scanner receiver;
    private PrintWriter sender;
    private String commands;

    public HubWorkerThread(String commands , Socket user) {
    try {
        this.sender = new PrintWriter(user.getOutputStream());
        this.receiver = new Scanner(user.getInputStream());
        this.commands = commands;
    }
        catch (IOException e){
            System.out.println("Error: Server disconnected!");
        }
    }

    @Override
    public void run() {
        // Sending and receiving information from the server to client or vice versa
        sender.println(commands);
        sender.flush();


        receiver.nextLine();

        //Close to avoid memory leak
        receiver.close();
        sender.close();

    }

}
