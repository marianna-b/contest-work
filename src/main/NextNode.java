package main;

public class NextNode {

    public static Node next(Node curr, int x) {

        if (curr.isList) {
            return null;
        }

        if (curr.key <= x) {

            return NextNode.next(curr.right, x);
        } else {

            if (!curr.left.isList) {
                if (checkLeftSon(curr, x)) {

                    return NextNode.next(curr.left, x);
                } else {

                    return thisNode(curr, x);
                }
            } else {

                return thisNode(curr, x);
            }
        }
    }

    private static boolean checkLeftSon(Node curr, int x) {

        return curr.left.maxInTree().key > x;
    }

    private static Node thisNode(Node curr, int x) {
        if (x != curr.key) {

            return curr;
        } else {

            return null;
        }
    }
}
