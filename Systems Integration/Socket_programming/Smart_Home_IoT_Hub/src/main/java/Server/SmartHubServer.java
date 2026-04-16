package Server;

import java.io.IOException;
import java.net.ServerSocket;

public class SmartHubServer implements Runnable{
    private ServerSocket port;
    private String json;

    public SmartHubServer(String json)  {
        try (ServerSocket port = new ServerSocket(8081)){
            port.accept();

        }
        catch (IOException e){
            System.out.println("Server disconnected!");

        }
    }

    @Override
    public void run() {

    }
}
