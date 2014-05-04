package main;

import lib.io.Scanner;

import java.io.PrintWriter;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
class rmq2 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        long[] a = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        /*SegmTree RMQ = new SegmTree(a);

        String operation;
        int l,  r;
        long x;
        while (true) {
            try {
                operation = in.nextToken();
                l = in.nextInt();
                r = in.nextInt();
                switch (operation) {
                    case ("min"):
                        out.println(RMQ.min(0, 0, n, l - 1, r));
                        break;
                    case ("set"):
                        x = in.nextLong();
                        RMQ.update("set", 0, 0, n, l - 1, r, x);
                        break;
                    case ("add"):
                        x = in.nextLong();
                        RMQ.update("add", 0, 0, n, l - 1, r, x);
                        break;
                }
            } catch (InputMismatchException e) {
                break;
            }

        }*/
    }
}
