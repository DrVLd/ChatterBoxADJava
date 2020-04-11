package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void createServer() throws IOException, ClassNotFoundException {
       ServerSocket server = new ServerSocket(port);

        System.out.println("Shutting down Socket server!!");
        while (true){
            Thread t = new Thread(new ThreadServer(server));
            t.start();
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

class ThreadServer implements  Runnable{

    ServerSocket server;

    public ThreadServer(ServerSocket server) {
        this.server = server;
    }

    @Override
    public void run() {

        while(true){
            System.out.println("Waiting for the client request");
            //creating socket and waiting for client connection
            Socket socket = null;
            try {
                socket = server.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //read from socket to ObjectInputStream object
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            //convert ObjectInputStream object to String
            String message = null;
            try {
                message = (String) ois.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("Message Received: " + message);
            //create ObjectOutputStream object
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            //write object to Socket
            try {
                oos.writeObject("Hi Client "+message);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //close resources
            try {
                ois.close();
                oos.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //terminate the server if client sends exit request
            if(message.equalsIgnoreCase("exit")) break;
        }
    }
}