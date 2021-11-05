package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame implements KeyListener{

    JPanel panel;
    Button key0;
    Button key1;
    Button key2;
    Button key3;
    Button key4;
    Button key5;
    Button key6;
    Button key7;
    Button key8;
    Button key9;
    Button keyMin;
    Button keySum;
    Button keyDiv;
    Button keyMult;
    Button keyPer;
    Button keyEq;
    Button keyDelAll;
    Button keyDelLast;
    Button keyParent1;
    Button keyParent2;
    JTextField operation;
    JTextField result;
    JLabel title;

    public GUI(){

        this.setTitle("Expression Tree Calculator");
        this.setVisible(true);
        this.setSize(300, 300);

        this.panel = new JPanel();
        this.getContentPane().add(this.panel);
        this.panel.setLayout(null);
        this.panel.setBackground(Color.decode("#c7e6eb"));
        this.setResizable(false);

        this.operation = new JTextField(20);
        this.operation.setSize(270, 40);
        this.operation.setLocation(10, 10);
        this.operation.addKeyListener(this);
        this.panel.add(this.operation);
        this.key1 = new Button(this, "1", 10, 60, 0);
        this.key2 = new Button(this, "2", 60, 60, 0);
        this.key3 = new Button(this, "3", 110, 60, 0);
        this.key4 = new Button(this, "4", 10, 110, 0);
        this.key5 = new Button(this, "5", 60, 110, 0);
        this.key6 = new Button(this, "6", 110, 110, 0);
        this.key7 = new Button(this, "7", 10, 160, 0);
        this.key8 = new Button(this, "8", 60, 160, 0);
        this.key9 = new Button(this, "9", 110, 160, 0);
        this.keyParent1 = new Button(this, "(", 10, 210, 0);
        this.key0 = new Button(this, "0", 60, 210, 0);
        this.keyParent2 = new Button(this, ")", 110, 210, 0);
        this.keySum = new Button(this, "+", 160, 60, 1);
        this.keyMin = new Button(this, "-", 160, 110, 0);
        this.keyMult = new Button(this, "*", 160, 160, 0);
        this.keyDiv = new Button(this, "/", 160, 210, 0);
        this.keyPer = new Button(this, "%", 210, 60, 20);
        this.keyDelLast = new Button(this, "DEL", 210, 110, 20);
        this.keyDelAll = new Button(this, "AC", 210, 160, 20);
        this.keyEq = new Button(this, "=", 210, 210, 20);

        this.panel.repaint();
        this.setDefaultCloseOperation(3);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
