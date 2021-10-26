package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static final String ip = "127.0.0.1";
    private static final int puerto = 9090;
    //public static GUI frame;

    public static void main(String[] args) throws IOException {

        //frame = new GUI();

        Socket socket = new Socket(ip, puerto);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));


        //socket.close();

    }
}
