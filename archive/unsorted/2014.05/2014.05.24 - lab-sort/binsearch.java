package main;

import lib.io.Scanner;

import java.io.PrintWriter;

public class binsearch {
    long[] a;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        int m = in.nextInt();
        int l, r;
        long elem;
        for (int i = 0; i < m; i++) {
            elem = in.nextLong();
            l = searchFirst(elem, -1, n - 1);
            if (l != -1 && a[l] == elem) {
                r = searchLast(elem, 0, n);
                out.println((l + 1) + " " + (r + 1));
            } else {
                out.println(-1 + " " + -1);
            }
        }
    }

    public int searchFirst(long elem, int l, int r) {
        if (r - l <= 1)
            return r;

        int m = (l + r) / 2;
        if (a[m] < elem)
            return searchFirst(elem, m, r);
        else
            return searchFirst(elem, l, m);
    }

    public int searchLast(long elem, int l, int r) {
        if (r - l <= 1)
            return l;

        int m = (l + r) / 2;
        if (a[m] <= elem)
            return searchLast(elem, m, r);
        else
            return searchLast(elem, l, m);
    }

}
