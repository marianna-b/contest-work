package main;

public class Node {

    public int key;
    public Color color;
    public Node left, right, parent;
    boolean isList;

    public static enum Color {
        RED, BLACK
    }

    public Node(Node p) {
        color = Color.BLACK;
        parent = p;
        left = null;
        right = null;
        isList = true;
    }

    public Node(int k, Node p) {
        key = k;
        color = Color.RED;
        parent = p;
        left = new Node(this);
        right = new Node(this);
        isList = false;
    }

    public Node exists(int x) {

        if (isList)
            return null;

        if (key == x) {

            return this;
        }

        if (x < key) {

            if (left != null && !left.isList) {

                return left.exists(x);
            } else {

                return null;
            }
        } else {

            if (right != null && !right.isList) {

                return right.exists(x);
            } else {

                return null;
            }
        }
    }

    public Node minInTree() {
        if (left != null && !left.isList) {

            return left.minInTree();
        }
        return this;
    }

    public Node maxInTree() {
        if (right != null && !right.isList) {

            return right.maxInTree();
        }
        return this;
    }
}