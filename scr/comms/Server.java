package comms;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import tree.ExpressionTree;
import tree.Node;

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

    static public String evaluateExpression(String Infix){
        float result;
        String output;

        // Creates the Expression Tree

        ExpressionTree tree = new ExpressionTree();
        Node root = tree.constructTreeInfix(Infix);

        // Evaluates the expression

        result = tree.Evaluate(root);

        // Return the value

        output = Float.toString(result);
        return output;
    }


}