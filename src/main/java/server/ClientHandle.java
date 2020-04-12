package server;

import core.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandle  implements  Runnable {


    private Socket client;

    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public ClientHandle(Socket client) {
        this.client = client;
        try {
            this.ois = new ObjectInputStream(client.getInputStream());
            this.oos = new ObjectOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        try{
        while (true) {

                Object obj = ois.readObject();
                if (obj != null) {
                    Message m = (Message) obj;
                    System.out.println(m);
                } else {
                    System.out.println("No");
                }

        }
        } catch (IOException | ClassNotFoundException ex){

        } finally {
            try {

                ois.close();
                oos.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

