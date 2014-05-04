package main;

public class FixDel {

    public static Node balance(Node tree, Node curr) {
        if (curr.parent == null) {
            curr.color = Node.Color.BLACK;
            return curr;
        }

        return doBalance(tree, curr);
    }

    public static Node doBalance(Node tree, Node x) {
        Node p = x.parent;
        Node s = RedBlack.getBrother(x);

        if (s.color == Node.Color.RED) {
            p.color = Node.Color.RED;
            s.color = Node.Color.BLACK;

            if (x == p.left)
                RedBlack.rotateLeft(p);
            else
                RedBlack.rotateRight(p);
            p = x.parent;
            s = RedBlack.getBrother(x);
        }

        if (!s.isList && (p.color == Node.Color.BLACK)
                && (s.color == Node.Color.BLACK) && (s.left.color == Node.Color.BLACK)
                && (s.right.color == Node.Color.BLACK)) {
            s.color = Node.Color.RED;
            return balance(tree, p);
        }
        if (!s.isList && (p.color == Node.Color.RED)
                && (s.color == Node.Color.BLACK) && (s.left.color == Node.Color.BLACK)
                && (s.right.color == Node.Color.BLACK)) {
            s.color = Node.Color.RED;
            p.color = Node.Color.BLACK;
            return toRoot(x);
        }

        if (s.color == Node.Color.BLACK) {

            if (!s.isList && (x == p.left)
                    && (s.right.color == Node.Color.BLACK) && (s.left.color == Node.Color.RED)) {
                s.color = Node.Color.RED;
                s.left.color = Node.Color.BLACK;
                RedBlack.rotateRight(s);
            } else if (!s.isList && (x == p.right)
                    && (s.left.color == Node.Color.BLACK) && (s.right.color == Node.Color.RED)) {
                s.color = Node.Color.RED;
                s.right.color = Node.Color.BLACK;
                RedBlack.rotateLeft(s);
            }
            p = x.parent;
            s = RedBlack.getBrother(x);
        }

        s.color = p.color;
        p.color = Node.Color.BLACK;

        if (x == p.left) {
            if (s.right != null)
                s.right.color = Node.Color.BLACK;
            RedBlack.rotateLeft(p);
        } else {
            if (s.left != null)
                s.left.color = Node.Color.BLACK;
            RedBlack.rotateRight(p);
        }

        return toRoot(x);
    }

    public static Node toRoot(Node x) {
        Node y = x;

        while (y.parent != null) {
            y = y.parent;
        }
        return y;
    }
}
