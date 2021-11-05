package comms;

import tree.ExpressionTree;
import tree.Node;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class that starts the socket communication and reads the clients information
 * @author Valesska Blanco
 * @author Ramsés Gutiérrez
 * @version 1
 */

public class Server {
    public static boolean running = true;

    /**
     * Creates the expression tree and evaluates the result
     * @param Infix
     */

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
    /**
     * Generates the server and accepts the clients
     * @param args
     */
    public static void main(String[] args){
        ServerSocket server = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        int clients = 0;

        final int PUERTO = 5000;

        try{
            server = new ServerSocket(PUERTO);
            System.out.println("[SERVER] Servidor Iniciado...");

            while(running){
                sc = server.accept();
                System.out.println("[SERVER] Cliente conectado.");

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                String[] expresion = in.readUTF().split("#");
                int id = Integer.parseInt(expresion[1]);
                if (id == 0){
                    clients++;
                    id = clients;
                }
                System.out.println("Numero de cliente: " + Integer.toString(id));


                System.out.println("Expresion a evaluar: " + expresion[0]);
                String resultado = evaluateExpression(expresion[0]);
                System.out.println("Resultado: " + resultado);

                out.writeUTF(resultado + "#" + Integer.toString(id));

                sc.close();


            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
