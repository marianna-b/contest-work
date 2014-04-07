package main;

public class FixIns {

    public static Node balance(Node tree, Node x) {

        if (x.parent == null) {
            x.color = Node.Color.BLACK;
            return x;
        }

        Node p = x.parent;
        if (p.color == Node.Color.BLACK) {
            return toRoot(x);
        }
        return doBalance(tree, x);
    }

    public static Node doBalance(Node tree, Node x) {
        Node p = x.parent;
        Node g = p.parent;
        Node u = RedBlack.getUncle(x);


        if (u != null && u.color == Node.Color.RED && p.color == Node.Color.RED) {
            p.color = Node.Color.BLACK;
            u.color = Node.Color.BLACK;
            g.color = Node.Color.RED;
            return balance(tree, g);
        } else {
            if (x == p.right && p == g.left) {
                RedBlack.rotateLeft(p);

                x = x.left;
                p = x.parent;
                g = p.parent;
            } else if (x == p.left && p == g.right) {
                RedBlack.rotateRight(p);

                x = x.right;
                p = x.parent;
                g = p.parent;
            }

            p.color = Node.Color.BLACK;
            if (g != null) {
                g.color = Node.Color.RED;
                if (x == p.left && p == g.left)
                    RedBlack.rotateRight(g);
                else
                    RedBlack.rotateLeft(g);
            }
            return balance(tree, g);
        }
    }


    public static Node toRoot(Node x) {
        Node y = x;

        while (y.parent != null) {
            y = y.parent;
        }
        return y;
    }
}
