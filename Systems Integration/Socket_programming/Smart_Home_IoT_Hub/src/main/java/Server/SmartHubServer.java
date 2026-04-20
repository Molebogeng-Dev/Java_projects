package Server;

import java.io.IOException;
import java.net.ServerSocket;

public class SmartHubServer implements Runnable{
    private String json;

    public SmartHubServer(String json)  {
            this.json = json;
    }

    @Override
    public void run() {
        try (ServerSocket port = new ServerSocket(8081)) {

            //port listening and sending data to a connector
            new Server(json, port.accept());

        } catch (IOException e) {
            throw new RuntimeException( "Server disconnected!" );
        }
    }
}
