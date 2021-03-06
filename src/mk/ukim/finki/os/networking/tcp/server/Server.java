package mk.ukim.finki.os.networking.tcp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// Pretstavuva server koj prifakja novi konekcii,
// i kreva Worker-i za da gi opsluzhat
public class Server extends Thread {

    @Override
    public void run() {

        try {
            System.err.println("SERVER: starting...");
            ServerSocket serverSocket = new ServerSocket(8000);
            System.err.println("SERVER: started...");

            while (true) {
                System.err.println("SERVER: Waiting for clients...");

                // Chekame nov klient;
                // Dokolku nema nov klient za prifakjanje,
                // programata blokira ovde
                Socket newClient = serverSocket.accept();

                System.err.println("SERVER: Got new client! Creating new Worker to serve the response...");

                // Kreirame nov Worker Thread,
                // i go prakjame klientot da bide usluzhen tamu
                new Worker(newClient).start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
