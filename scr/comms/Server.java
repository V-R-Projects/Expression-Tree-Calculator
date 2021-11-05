package comms;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final int puerto = 9090;
    public static Socket client;
    private static final ArrayList<Client> clients = new ArrayList<>();
    private static final ExecutorService pool = Executors.newFixedThreadPool(1000);

    @SuppressWarnings({ "resource" })

    public static void main() throws IOException {

        ServerSocket server = new ServerSocket(puerto);

        try {
            while (true) {

                System.out.println("[SERVER] Esperando conexón...");
                client = server.accept();
                System.out.println("[SERVER] Cliente conectado.");

                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                Client clientThread = new Client(client);
                clients.add(clientThread);
                //pool.execute(clientThread);
                System.out.println("hilo");

            }
        } catch (Exception e){

            server.close();
            System.out.println("Connection lost");
        }

    }


}