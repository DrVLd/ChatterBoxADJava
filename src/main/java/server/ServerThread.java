package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {

    static ServerSocket ss = null;
    static int port;
    Thread t;
    private static Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        DataInputStream dataIn = null;
        DataOutputStream dataOut = null;
        int i = 0;
        while (i < 5) {
            System.out.println("TTTTT");
        }
    }
}
