package comms;

import tree.ExpressionTree;
import tree.Node;

public class ClientePrueba {

   static public String evaluateExpression(String Infix){
        float result;
        String output;

        // Creates the Expression Tree

        ExpressionTree tree = new ExpressionTree();
        Node root = tree.constructTreeInfix(Infix);

        // Evaluates the expression

        result = tree.Evaluate(root);

        // Return the value

        output = Float.toString(result);
        return output;
    }
}
