package main;

public class InsertNode {

    public static void insert(Node curr, int x) {
        if (x > curr.key) {

            if (!curr.right.isList) {

                insert(curr.right, x);
            } else {

                curr.right = new Node(x, curr);
                RedBlack.balanceInsertion(curr.right);
            }

        } else {

            if (!curr.left.isList) {

                insert(curr.left, x);
            } else {

                curr.left = new Node(x, curr);
                RedBlack.balanceInsertion(curr.left);
            }
        }
    }
}
