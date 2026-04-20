package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HubWorkerThread {
    private Scanner receiver;
    private PrintWriter sender;

    public HubWorkerThread(String commands , Socket user)  {


        try {
            receiver = new Scanner(user.getInputStream());
            sender = new PrintWriter(user.getOutputStream());

            // Sending and receiving information from the server to client or vice versa
            while (commands != null) {
                sender.println(commands);
                receiver.nextLine();
            }


            //Close to avoid memory leak
            receiver.close();
            sender.close();
        }
        catch (IOException e){
            System.out.println("Error: Server disconnected!");
        }
    }

}
