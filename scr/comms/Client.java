package comms;

import interfaz.GUI;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable {


    private static final String ip = "127.0.0.1";
    private static final int puerto = 9090;
    private Socket client;
    private DataInputStream in;
    private DataOutputStream out;
    private GUI calc;


    public Client(Socket clientSocket) throws IOException {

        this.client = clientSocket;
        calc = new GUI(); // creates a calculator
        this.in = new DataInputStream(client.getInputStream());
        this.out = new DataOutputStream(client.getOutputStream());
    }

    @Override
    public void run(){

        while(true){

            if (calc.activate) {

                String datos = calc.getData();
                System.out.println(datos);

                String result = Server.evaluateExpression(datos);
                calc.operation.setText(result);

                calc.activate = false;

            }
        }
    }
    public void main(String[] args) throws IOException {

        Socket server = new Socket("localhost",puerto);
        DataInputStream in = new DataInputStream(server.getInputStream());
        DataOutputStream out = new DataOutputStream(server.getOutputStream());
        this.run();
    }
}
