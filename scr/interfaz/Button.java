package interfaz;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

class Button implements ActionListener {
    JButton button;
    GUI interfaz;
    String opText;

    public Button(GUI clientInterface, String text, int x, int y, int plus) {
        this.interfaz = clientInterface;
        this.opText = text;
        this.button = new JButton(text);
        this.button.setSize(40 + plus, 40);
        this.button.setLocation(x, y);
        this.button.addActionListener(this);
        this.interfaz.panel.add(this.button);
    }

    public void actionPerformed(ActionEvent e) {


    }
}
