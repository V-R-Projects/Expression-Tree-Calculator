package com;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final int puerto = 9090;
    private static final ArrayList<ClientHandler> clients = new ArrayList<>();
    private static final ExecutorService pool = Executors.newFixedThreadPool(1000);

    @SuppressWarnings({ "resource" })

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(puerto);

        while (true) {

            System.out.println("[SERVER] Esperando conexón...");
            Socket client = server.accept();
            System.out.println("[SERVER] Cliente conectado.");
            ClientHandler clientThread = new ClientHandler(client);
            clients.add(clientThread);

            pool.execute(clientThread);

        }

    }


}
