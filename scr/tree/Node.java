package tree;

import java.util.ArrayList;

public class Node {
    public String value;
    public Node left, right;

    Node(String item) {
        value = item;
        left = right = null;
    }
    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(value);
        buffer.append('\n');
        ArrayList<Node> it = new ArrayList<Node>();
        it.add(left);
        it.add(right);
        for (int i = 0; i < 2; i++) {
            Node next = it.get(i);
            if(next != null) {
                if (i == 0) {
                    next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
                } else {
                    next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
                }
            }
        }
    }

}
