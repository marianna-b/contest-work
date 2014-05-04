package main;



import lib.io.Scanner;
import lib.io.segmTree;

import java.io.PrintWriter;
import java.util.InputMismatchException;

public class rmq {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        segmTree RMQ = new segmTree(a);

        String operation;
        while (true) {
            try {
                operation = in.nextToken();
                switch (operation) {
                    case ("min"):
                        int l = in.nextInt();
                        int r = in.nextInt();
                        RMQ.min(0, 0, n, l, r);
                        break;
                    case ("set"):
                        int idx = in.nextInt();
                        int val = in.nextInt();
                        RMQ.update(0, 0, n, idx, val);
                        break;
                }
            } catch (InputMismatchException e) {
                break;
            }

        }
    }
}
