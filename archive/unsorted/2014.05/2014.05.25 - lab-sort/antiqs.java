package main;


import lib.io.Scanner;

import java.io.PrintWriter;

public class antiqs {

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];


        for (int i = 0; i < n; i++)
            a[i] = i + 1;

        for (int i = 2; i < n; i++) {
            int x = a[i / 2];
            a[i / 2] = a[i];
            a[i] = x;
        }

        for (int i = 0; i < n; i++)
            out.print(a[i] + " ");
    }
}
