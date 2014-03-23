package main;





import lib.io.Scanner;

import java.io.PrintWriter;

public class isheap {
    public void solve(int testNumber, Scanner in, PrintWriter out) {

        int n = in.nextInt();
        int[] a = new int[n + 1];
        boolean flag = true;

        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            if (2 * i <= n && a[i] > a[2*i]) {
                flag = false;
            }
        }

        if (flag) {
            out.println("YES");
        }
        else {
            out.println("NO");
        }
    }
}
