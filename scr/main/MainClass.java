package main;

import comms.Server;
import interfaz.GUI;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class MainClass {
    static String input = "";

    public static void main(String[] args) throws IOException {

        while (true) {
            InputStream stream = System.in;
            Scanner scanner = new Scanner(stream);
            System.out.println("Digite 'New' para abrir otro cliente");
            input = scanner.next();
            if (input.equals("New")){
                GUI client = new GUI();
            }
        }
    }

}
