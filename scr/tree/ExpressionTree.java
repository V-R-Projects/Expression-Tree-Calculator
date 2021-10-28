package tree;

import java.util.Stack;

public class ExpressionTree {

    // A utility function to check if 'c'
    // is an operator

    boolean isOperand(String c) {
        return !c.equals("+") && !c.equals("-")
                && !c.equals("*") && !c.equals("/")
                && !c.equals("^") && !c.equals("(")
                && !c.equals(")") && !c.equals("=");
    }

    // Utility function to do inorder traversal
    void inorder(Node t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.value + " ");
            inorder(t.right);
        }
    }

    // Utility function to print the tree
    void toString(Node t){
        System.out.println(t.toString());
    }


    // Returns root of constructed tree for given
    // postfix expression
    Node constructTreePostfix(String postfixInput) {
        String[] postfix = this.split(postfixInput);
        Stack<Node> st = new Stack<>();
        Node t, t1, t2;

        // Traverse through every character of
        // input expression
        for (String s : postfix) {

            // If operand, simply push into stack
            if (isOperand(s)) {
                t = new Node(s);
            }
            else { // operator

                t = new Node(s);

                // Pop two top nodes
                // Store top
                t1 = st.pop();      // Remove top
                t2 = st.pop();

                //  make them children
                t.right = t1;
                t.left = t2;

                // System.out.println(t1 + "" + t2);
                // Add this subexpression to stack

            }
            st.push(t);
        }

        //  only element will be root of expression
        // tree
        t = st.peek();
        st.pop();

        return t;
    }

    Node constructTreeInfix(String InfixInput) {
        String[] Infix = this.split(InfixInput);
        Stack<Node> st = new Stack<>();
        Node t, t1, t2;

        // Traverse through every character of
        // input expression
        for (int i = 0; i < Infix.length; i++) {

            // If operand, simply push into stack
            if (isOperand(Infix[i])) {
                if(st.empty()){
                    t = new Node(Infix[i]);
                }
                else if(isOperand(st.peek().value)){
                    t = st.pop();
                    t.value += Infix[i];
                }
                else {
                    t = new Node(Infix[i]);
                }
            }
            // operator
            else {
                t = new Node(Infix[i]);

                if(isOperand(st.firstElement().value)){ // first case
                    t1 = st.pop();
                    t.left = t1;
                }
                else {
                    // Pop two top nodes
                    // Store top
                    t1 = st.pop();      // Remove top
                    t2 = st.peek();

                    if (priority(t2.value) >= priority(t.value)){
                        st = merge(st, t1, priority(t.value));
                        if (!t.value.equals("=") && !t.value.equals(")")) {
                            t1 = st.pop();
                            t.left = t1;
                        }
                    }
                    else{
                        t.left = t1;
                    }
                }


            }
            // Add this subexpression to stack
            if (!t.value.equals("=") && !t.value.equals(")")) {
                st.push(t);
            }

        }

        //  only element will be root of expression
        // tree
        t = st.pop();

        return t;
    }

    //priority of operators
    private int priority(String op){
        return switch (op){
            case "+", "-" -> 0;
            case "*", "/" -> 1;
            case "^" -> 2;
            default -> -1;
        };
    }

    // merge all the stack
    private Stack<Node> merge(Stack<Node> st, Node right, int priority){
        Node t;
        do{
            t = st.pop();
            t.right = right;
            right = t;
            if (st.empty()){
                break;
            }
        }while (priority(st.peek().value) >= priority);
        st.push(t);
        return st;
    }


    // splits String to an array
    private String[] split(String input){
        String[] output = new String[input.length()];
        for(int i = 0; i < input.length(); i++){
            output[i] = input.substring(i,i+1);
        }
        return output;
    }

    public static void main(String[] args) {

        ExpressionTree et = new ExpressionTree();
//        String postfix = "23+ef*g*-";
//        Node root = et.constructTreePostfix(postfix);
        String Infix = "a+b/c^2*25=";
        Node root = et.constructTreeInfix(Infix);
        System.out.println("infix expression is");
        et.inorder(root);
        System.out.println("\nTree is:");
        et.toString(root);

    }
}
