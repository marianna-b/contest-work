package main;

public class RedBlack {

    public static Node getBrother(Node x) {
        Node p = x.parent;

        if (p == null)
            return null;

        if (p.left == x)
            return p.right;
        else
            return p.left;
    }

    public static Node getUncle(Node x) {
        Node p = x.parent;
        if (p == null)
            return null;

        return getBrother(p);
    }

    public static void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != null && !y.isList)
            y.left.parent = x;

        y.parent = x.parent;

        Node g = x.parent;
        if (g != null) {
            if (g.left == x)
                g.left = y;
            else
                g.right = y;

        }

        y.left = x;

        if (x != null && !x.isList)
            x.parent = y;
    }

    public static void rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;

        if (y.right != null)
            y.right.parent = x;

        y.parent = x.parent;

        Node g = x.parent;
        if (g != null) {
            if (g.left == x)
                g.left = y;
            else
                g.right = y;
        }

        y.right = x;

        if (x != null && !x.isList)
            x.parent = y;
    }
}
