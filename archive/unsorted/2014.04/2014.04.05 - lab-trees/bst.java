package main;

        import lib.io.Scanner;
        import java.io.PrintWriter;
        import java.util.InputMismatchException;

public class bst {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String operation;
        int x;
        Node tree = null;
        Node result;

        while (true) {
            try {
                operation = in.nextToken();
                x = in.nextInt();

                switch (operation.charAt(0)) {

                    case 'i':
                        if (tree == null) {

                            tree = new Node(x, null);
                        } else {
                            if (tree.exists(x) == null) {
                                InsertNode.insert(tree, x);
                            }
                        }
                        break;

                    case 'd':
                        if (tree != null) {

                            result = tree.exists(x);
                        } else {

                            result = null;
                        }

                        if (result != null) {

                            if (result.parent == null) {

                                if (DeleteNode.deleteRoot(tree) < 0) {

                                    tree = null;
                                }
                            } else {

                                DeleteNode.delete(tree, result);
                            }
                        }

                        break;

                    case 'e':

                        if (tree != null) {

                            result = tree.exists(x);
                        } else {

                            result = null;
                        }

                        if (result != null) {

                            out.println("true");
                        } else {

                            out.println("false");
                        }

                        break;

                    case 'n':

                        result = NextNode.next(tree, x);

                        if (result == null) {

                            out.println("none");
                        } else {

                            out.println(result.key);
                        }

                        break;

                    case 'p':

                        result = PreviousNode.prev(tree, x);

                        if (result == null) {

                            out.println("none");
                        } else {

                            out.println(result.key);
                        }

                        break;
                }
            } catch (InputMismatchException e) {
                break;
            }
        }
    }
}
