package main;

public class DeleteNode {

    public static Node delete(Node tree, Node x) {
        if (x.color == Node.Color.RED)
            return deleteRed(tree, x);
        else
            return deleteBlack(tree, x);
    }

    public static Node deleteRed(Node tree, Node x) {
        if (x.left.isList && x.right.isList) {
            deleteList(x);
            return tree;
        }

        if (x.left.isList) {
            replaceWithR(x);
            return tree;
        }
        if (x.right.isList) {
            replaceWithL(x);
            return tree;
        }

        Node p = toReplace(x);
        x.key = p.key;

        return delete(tree, p);

    }

    public static Node deleteBlack(Node tree, Node x) {

        Node p = x.parent;

        if (x.left.isList && x.right.isList) {
            if (p != null) {
                x = deleteList(x);
                return FixDel.balance(tree, x);
            } else {
                return null;
            }
        }
        if (x.left.isList) {
            replaceWithR(x);
            return tree;
        }
        if (x.right.isList) {
            replaceWithL(x);
            return tree;
        }

        p = toReplace(x);
        x.key = p.key;

        return delete(tree, p);
    }


    private static Node toReplace(Node x) {
        Node y = x.right;

        while (!y.left.isList && y.left != null) {
            y = y.left;
        }
        return y;
    }

    private static void replaceWithR(Node x) {
        Node y = x.right;

        x.isList = y.isList;
        x.key = y.key;

        x.left = y.left;
        if (x.left != null)
            x.left.parent = x;
        x.right = y.right;
        if (x.right != null)
            x.right.parent = x;
    }

    private static void replaceWithL(Node x) {
        Node y = x.left;

        x.isList = y.isList;
        x.key = y.key;

        x.left = y.left;

        if (x.left != null)
            x.left.parent = x;
        x.right = y.right;

        if (x.right != null)
            x.right.parent = x;
    }

    private static Node deleteList(Node x) {
        Node p = x.parent;

        if (p.left == x) {
            p.left = new Node(p);
            return p.left;
        } else {
            p.right = new Node(p);
            return p.right;
        }
    }
}
