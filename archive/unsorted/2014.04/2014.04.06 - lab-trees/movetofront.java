package main;

import lib.io.Scanner;
import lib.io.Treap;

import java.io.PrintWriter;

public class movetofront {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        Treap tree = new Treap();

        for (int i = 0; i < n; i++) {
            tree.append(i + 1);
        }

        int l, r;

        for (int i = 0; i < m; i++) {
            l = in.nextInt();
            r = in.nextInt();
            tree.moveToFront(l, r);
        }

        tree.printTree(out);
    }
}
