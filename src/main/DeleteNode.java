package main;

public class DeleteNode {

    public static void delete(Node tree, Node x) {

        if (x.left.isList && x.right.isList) {
            DeleteNode.deleteList(x);
            return;
        }

        if (x.left == null) {
            DeleteNode.deleteWithR(x);
            if (x.color == Node.Color.RED) {
                x.right.color = Node.Color.BLACK;
            } else {
                DeleteNode.delete(tree, x.right);
            }
            return;
        }

        if (x.right == null) {
            DeleteNode.deleteWithL(x);
            if (x.color == Node.Color.RED) {
                x.left.color = Node.Color.BLACK;
            } else {
                DeleteNode.delete(tree, x.left);
            }
            return;
        }

        Node s = RedBlack.getBrother(x);
        Node p = x.parent;
        if (s != null && s.color == Node.Color.RED) {
            p.color = Node.Color.RED;
            s.color = Node.Color.BLACK;

            if (p.left ==)
                return;
        }
    }

    public static int deleteRoot(Node x) {

        if (x.left == null && x.right == null) {
            return -1;
        }

        if (x.left == null) {
            DeleteNode.deleteWithR(x);
            return 0;
        }

        if (x.right == null) {
            DeleteNode.deleteWithL(x);
            return 0;
        }

        Node p = NextNode.next(x, x.key);
        x.key = p.key;
        delete(x, p);
        return 0;
    }

    private static void deleteList(Node x) {
        if (x.parent.left == x) {

            x.parent.left = new Node(x.parent);
        } else {

            x.parent.right = new Node(x.parent);
        }
    }

    private static void deleteWithR(Node x) {
        x.key = x.right.key;
        x.left = x.right.left;
        x.right = x.right.right;
    }

    private static void deleteWithL(Node x) {
        x.key = x.left.key;
        x.right = x.left.right;
        x.left = x.left.left;
    }
}
