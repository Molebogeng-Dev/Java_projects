package Server;

import java.io.IOException;
import java.net.ServerSocket;

public class SmartHubServer {
    private ServerSocket port;
    private String json;

    public SmartHubServer(String json)  {
        try (ServerSocket port = new ServerSocket(5000)){
            port.accept();

        }
        catch (IOException e){

        }
    }
}
