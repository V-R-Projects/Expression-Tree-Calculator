package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private final BufferedReader in;
    private final PrintWriter out;

    public ClientHandler(Socket clientSocket) throws IOException {

        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    @Override
    public void run() {

        try {

            while (true) {

                String datos = in.readLine();
            }

        } catch (IOException e) {

            System.err.println("Cliente Desconectado...");
        } finally {

            try {

                in.close();
            } catch (IOException e) {

                e.printStackTrace();
            }

            out.close();
        }

    }
}
