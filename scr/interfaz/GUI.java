package interfaz;

import comms.Cliente;

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
    Button consult;
    public JTextField operation;
    JTextField result;
    JLabel title;

    public boolean activate = false;

    public GUI(){

        this.setTitle("Expression Tree Calculator");
        this.setVisible(true);
        this.setSize(350, 400);

        this.panel = new JPanel();
        this.getContentPane().add(this.panel);
        this.panel.setLayout(null);
        this.panel.setBackground(Color.decode("#c7e6eb"));
        this.setResizable(false);

        this.operation = new JTextField(20);
        this.operation.setSize(310, 40);
        this.operation.setLocation(10, 10);
        this.operation.addKeyListener(this);
        this.panel.add(this.operation);

        this.key1 = new Button(this, "1", 10, 60, 0);
        this.key2 = new Button(this, "2", 70, 60, 0);
        this.key3 = new Button(this, "3", 130, 60, 0);
        this.key4 = new Button(this, "4", 10, 110, 0);
        this.key5 = new Button(this, "5", 70, 110, 0);
        this.key6 = new Button(this, "6", 130, 110, 0);
        this.key7 = new Button(this, "7", 10, 160, 0);
        this.key8 = new Button(this, "8", 70, 160, 0);
        this.key9 = new Button(this, "9", 130, 160, 0);
        this.keyParent1 = new Button(this, "(", 10, 210, 0);
        this.key0 = new Button(this, "0", 70, 210, 0);
        this.keyParent2 = new Button(this, ")", 130, 210, 0);
        this.keySum = new Button(this, "+", 190, 60, 1);
        this.keyMin = new Button(this, "-", 190, 110, 0);
        this.keyMult = new Button(this, "*", 190, 160, 0);
        this.keyDiv = new Button(this, "/", 190, 210, 0);
        this.keyPer = new Button(this, "%", 250, 60, 20);
        this.keyDelLast = new Button(this, "DEL", 250, 110, 20);
        this.keyDelAll = new Button(this, "AC", 250, 160, 20);
        this.keyEq = new Button(this, "=", 250, 210, 20);
        this.consult = new Button(this, "Consultar",125,260,50);

        this.panel.repaint();
        this.setDefaultCloseOperation(3);
    }

    public String getData(){
        return this.operation.getText();
    }
    public void setActivate(boolean activate){
        this.activate = activate;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (!Character.isDigit(e.getKeyChar()) && !"/*+-^=".contains(Character.toString(e.getKeyChar()))) {
            e.consume();
        }
        else if(e.getKeyChar() == '='){
            Cliente client = new Cliente(operation.getText() + "=");
            operation.setText(client.enviar());
            e.consume();
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
