package lib.io;

import java.io.PrintWriter;
import java.util.Random;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class Treap {
    private Node root;

    public void append(int key) {
        root = append(root, key);
    }

    public void moveToFront(int left, int right) {
        left--;
        right--;
        root = moveToFront(root, left, right);
    }

    public void printTree(PrintWriter out) {
        printTree(root, out);
        out.println();
    }

    public static final Random rnd = new Random(1);

    public static final class Node {
        int val, prior, size;
        Node left, right;

        public Node(int val) {
            this.val = val;
            prior = rnd.nextInt();
            size = 1;
        }
    }

    public static int size(Node n) {
        return n == null ? 0 : n.size;
    }

    public static void updateSize(Node n) {
        if (n != null) {
            n.size = 1 + size(n.left) + size(n.right);
        }
    }

    public static final class SplitResult {
        Node left, right;

        public SplitResult(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

    public static Node merge(Node l, Node r) {
        if (l == null)
            return r;
        if (r == null)
            return l;

        if (l.prior > r.prior) {
            l.right = merge(l.right, r);
            updateSize(l);
            return l;
        } else {
            r.left = merge(l, r.left);
            updateSize(r);
            return r;
        }
    }

    public static SplitResult split(Node n, int key) {
        return split(n, key, 0);
    }

    public static SplitResult split(Node n, int key, int add) {
        if (n == null) {
            return new SplitResult(null, null);
        }

        int nKey = add + size(n.left);
        if (key < nKey) {
            SplitResult result = split(n.left, key, add);
            updateSize(n.left);
            n.left = result.right;
            updateSize(result.right);
            updateSize(result.left);
            updateSize(n);
            return new SplitResult(result.left, n);
        } else {
            SplitResult result = split(n.right, key, add + size(n.left) + 1);
            updateSize(n.right);
            n.right = result.left;
            updateSize(result.right);
            updateSize(result.left);
            updateSize(n);
            return new SplitResult(n, result.right);
        }
    }

    public static Node append(Node node, int val) {
        return merge(node, new Node(val));
    }

    public static Node moveToFront(Node node, int left, int right) {
        SplitResult x = split(node, left - 1);
        SplitResult y = split(x.right, right - left);
        Node res = merge(y.left, x.left);
        return merge(res, y.right);
    }

    public static void printTree(Node node, PrintWriter out) {
        if (node != null) {
            printTree(node.left, out);
            out.print(node.val + " ");
            printTree(node.right, out);
        }
    }
}
