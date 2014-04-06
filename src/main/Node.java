package main;

public class Node {

    public int key;
    public Color color;
    public boolean isList;
    public Node left, right, parent;


    public static enum Color {
        RED, BLACK
    }

    public Node(Node p) {
        isList = true;
        color = Color.BLACK;
        parent = p;
    }

    public Node(int k, Node p) {
        key = k;
        isList = false;
        color = Color.RED;
        parent = p;
        left = new Node(this);
        right = new Node(this);
    }

    public Node exists(int x) {

        if (this.isList) {
            return null;
        }

        if (key == x) {

            return this;
        }

        if (x < key) {

            if (!left.isList) {

                return left.exists(x);
            } else {

                return null;
            }
        } else {

            if (!right.isList) {

                return right.exists(x);
            } else {

                return null;
            }
        }
    }

    public Node minInTree() {
        if (!left.isList) {

            return left.minInTree();
        }
        return this;
    }

    public Node maxInTree() {
        if (!right.isList) {

            return right.maxInTree();
        }
        return this;
    }
}