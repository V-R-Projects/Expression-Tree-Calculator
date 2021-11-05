package comms;

import interfaz.GUI;
import tree.ExpressionTree;
import tree.Node;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    String msg;
    public Cliente(String msg) {
        this.msg = msg;
    }
    public String enviar() {
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;

        final String HOST = "127.0.0.1";
        final int PUERTO = 5000;

        try{
            sc = new Socket(HOST,PUERTO);
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF(msg);

            String result = in.readUTF();

            sc.close();

            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error";
    }

}
