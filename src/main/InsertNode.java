package main;

public class InsertNode {

    public static Node insert(Node curr, int x) {
        if (x > curr.key) {

            if (!curr.right.isList) {

                return insert(curr.right, x);
            } else {

                curr.right = new Node(x, curr);
                return RedBlack.balanceInsertion(curr.right);
            }

        } else {

            if (!curr.left.isList) {

                return insert(curr.left, x);
            } else {

                curr.left = new Node(x, curr);
                return RedBlack.balanceInsertion(curr.left);
            }
        }
    }
}
