package client;
import core.Chat;
import core.Message;
import core.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {


    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        //get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = new Socket(host.getHostName(), 9876);
        ObjectOutputStream  oos = new ObjectOutputStream(socket.getOutputStream());;
        ObjectInputStream ois = null;
        Scanner sc = new Scanner(System.in);
        while(true){
            //establish socket connection to server

            //write to socket using ObjectOutputStream

            System.out.println("Sending request to Socket Server");
            //if(i==4)oos.writeObject("exit");
            String messageText = sc.nextLine();
            Message m = new Message(1, messageText, new User(1, "anar", "parol"),
                                                               new User(2, "dima", "parol2"),
                                                                new Chat(1)
                                                                );
            oos.writeObject(m);
            //read the server response message
          //  messageois = new ObjectInputStream(socket.getInputStream());
            //String message = (String) ois.readObject();
            // System.out.println("Message: " + message);
            //close resources
//            ois.close();

           Thread.sleep(100);
        }
    }
}
