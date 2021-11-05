package interfaz;

import tree.ExpressionTree;
import tree.Node;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
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
                ExpressionTree tree = new ExpressionTree();
                String Infix = text + "=";
                Node root = tree.constructTreeInfix(Infix);
                this.interfaz.operation.setText(Float.toString(tree.Evaluate(root)));
                break;
            default:
                this.interfaz.operation.setText(text + this.opText);
                break;
        }
    }
}
