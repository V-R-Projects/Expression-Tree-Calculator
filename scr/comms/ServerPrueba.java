package comms;

import tree.ExpressionTree;
import tree.Node;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPrueba {

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

    public static void main(String[] args){
        ServerSocket server = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;

        final int PUERTO = 5000;

        try{
            server = new ServerSocket(PUERTO);
            System.out.println("[SERVER] Servidor Iniciado...");

            while(true){
                sc = server.accept();

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                String expresion = in.readUTF();

                String resultado = evaluateExpression(expresion);

                out.writeUTF(resultado);

                sc.close();


            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
