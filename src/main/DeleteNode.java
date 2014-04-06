package main;

public class DeleteNode {

    public static Node delete(Node tree, Node x) {

        Node p = x.parent;

        if (x.left.isList && x.right.isList) {

            deleteList(x);
            return RedBlack.balanceDeletion(p);
        }

        if (x.left.isList) {

            deleteWithR(x);
            return RedBlack.balanceDeletion(x);
        }

        if (x.right.isList) {

            deleteWithL(x);
            return RedBlack.balanceDeletion(x);
        }

        p = NextNode.next(tree, x.key);
        x.key = p.key;
        if (x.color == Node.Color.BLACK) {
            p.isList = true;
            p.color = Node.Color.BLACK;
            return RedBlack.balanceDeletion(p.parent);
        } else {
            return delete(tree, p);
        }
    }

    public static Node deleteRoot(Node x) {

        if (x.left.isList && x.right.isList) {
            return null;
        }

        if (x.left.isList) {
            DeleteNode.deleteWithR(x);

            return RedBlack.balanceDeletion(x);
        }

        if (x.right.isList) {
            DeleteNode.deleteWithL(x);

            return RedBlack.balanceDeletion(x);
        }

        Node p = NextNode.next(x, x.key);
        x.key = p.key;
        return delete(x, p);
    }

    private static void deleteList(Node x) {
        if (x.parent.left == x) {

            x.parent.left = new Node(x.parent);
        } else {

            x.parent.right = new Node(x.parent);
        }
    }

    private static void deleteWithR(Node x) {
        x.right.left.parent = x;
        x.right.right.parent = x;
        x.key = x.right.key;
        x.left = x.right.left;
        x.right = x.right.right;
    }

    private static void deleteWithL(Node x) {
        x.left.left.parent = x;
        x.left.right.parent = x;

        x.key = x.left.key;
        x.right = x.left.right;
        x.left = x.left.left;
    }
}
