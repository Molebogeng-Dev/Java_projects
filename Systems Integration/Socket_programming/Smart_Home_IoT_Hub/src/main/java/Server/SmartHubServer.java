package Server;

import jogamp.common.util.locks.SingletonInstanceServerSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SmartHubServer extends ValidCommands implements Runnable {
    static Socket serverPort;

    //To run the server first
    public static void main(String[] args) throws IOException {
        ServerSocket port = new ServerSocket(7777);

        //port listening and sending data to a connector
        System.out.println("Server up and running");
        serverPort = port.accept();
    }


    @Override
    public void run() {

        //port listening and sending data to a connector
       new HubWorkerThread(response(), serverPort);

    }
}
