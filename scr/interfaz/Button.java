package interfaz;

import comms.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Button implements ActionListener {
    JButton button;
    GUI interfaz;
    String opText;

    public Button(GUI clientInterface, String text, int x, int y, int plus) {
        this.interfaz = clientInterface;
        this.opText = text;
        this.button = new JButton(text);
        this.button.setSize(50 + plus, 40);
        this.button.setLocation(x, y);
        this.button.addActionListener(this);
        this.interfaz.panel.add(this.button);
    }

    public void actionPerformed(ActionEvent e) {
        click();
    }

    public void click(){
        String text = this.interfaz.operation.getText();
        switch (this.opText) {
            case "AC":
                this.interfaz.operation.setText("");
                break;
            case "DEL":
                if (text.length() > 0)
                    this.interfaz.operation.setText(text.substring(0, text.length() - 1));
                break;
            case "=":
                Cliente client = new Cliente(text + "=");
                this.interfaz.operation.setText(client.enviar());
                break;
            case "Consultar":

                break;
            default:
                this.interfaz.operation.setText(text + this.opText);
                break;
        }
    }
}
