package main;

public class RedBlack {

    public static void balanceInsertion(Node curr) {
        if (curr.parent == null) {
            curr.color = Node.Color.BLACK;
            return;
        }

        Node p = curr.parent;
        if (p.color == Node.Color.BLACK) {
            return;
        }

        Node g = p.parent;
        if (g == null) {
            p.color = Node.Color.BLACK;
            return;
        }

        Node u = getUncle(curr);
        if (u != null && u.color == Node.Color.RED) {

            p.color = Node.Color.BLACK;
            g.color = Node.Color.RED;
            balanceInsertion(g);
            return;
        }


        if (p.right == curr && g.left == p) {

            rotateLeft(p);
            curr = curr.left;
        } else if (curr == p.left && p == g.right) {

            rotateRight(p);
            curr = curr.right;
        }

        p.color = Node.Color.BLACK;
        g.color = Node.Color.RED;

        if (curr == p.left) {

            rotateRight(g);
        } else {

            rotateLeft(g);
        }
    }

    public static Node getUncle(Node curr) {
        Node p = curr.parent;
        if (p.parent.left == p) {

            return p.parent.right;
        } else {

            return p.parent.left;
        }
    }

    public static Node getBrother(Node curr) {
        Node p = curr.parent;
        if (p.left == curr) {
            return p.right;
        } else {

            return p.left;
        }
    }

    public static void rotateLeft(Node x) {
        Node curr = x.right;
        x.right = curr.left;
        curr.left = x;

        curr.parent = x.parent;
        x.parent = curr;
    }

    public static void rotateRight(Node x) {
        Node curr = x.left;
        x.left = curr.right;
        curr.right = x;

        curr.parent = x.parent;
        x.parent = curr;
    }
}
