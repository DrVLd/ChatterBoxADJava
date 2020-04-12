package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private int port;

    private List<ClientHandle> clientHandleList;

    private ExecutorService pool = Executors.newFixedThreadPool(400);
    public Server(int port) {
        this.port = port;
        this.clientHandleList  = new ArrayList<>();
    }

    public void createServer() throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(port);

        while (true){

            Socket client = server.accept();
            ClientHandle clientHandle = new ClientHandle(client);
            clientHandleList.add(clientHandle);
            pool.execute(clientHandle);

        }
 //       server.close();
}


    public static void main(String[] args) {
        try {
            new Server(9876).createServer();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
