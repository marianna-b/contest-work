package main;

public class InsertNode {

    public static Node insert(Node tree, Node curr, int x) {
        if (x > curr.key) {

            if (!curr.right.isList) {

                return insert(tree, curr.right, x);
            } else {

                curr.right = new Node(x, curr);

                return FixIns.balance(tree, curr.right);
            }

        } else {

            if (!curr.left.isList) {

                return insert(tree, curr.left, x);
            } else {

                curr.left = new Node(x, curr);

                return FixIns.balance(tree, curr.left);
            }
        }
    }
}
