package main;

import lib.io.Scanner;
import java.io.PrintWriter;

public class sort {
    int[] a;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();

        mergeSort(0, n);
        for (int i = 0; i < n; i++)
            out.print(a[i] + " ");
    }

    public void mergeSort(int l, int r) {
        if (r - l == 1)
            return;

        int m = (l + r) / 2;

        mergeSort(l, m);
        mergeSort(m, r);
        merge(l, m, r);
    }

    public void merge(int l, int m, int r) {
        int[] curr = new int[r - l];

        int idx1 = l;
        int idx2 = m;

        for (int i = 0; i < curr.length; i++) {

            if (idx1 >= m) {
                curr[i] = a[idx2];
                idx2++;
                continue;
            }
            if (idx2 >= r) {
                curr[i] = a[idx1];
                idx1++;
                continue;
            }

            if (a[idx1] > a[idx2]) {
                curr[i] = a[idx2];
                idx2++;
            } else {
                curr[i] = a[idx1];
                idx1++;
            }
        }

        for (int i = 0; i < curr.length; i++) {
            a[l + i] = curr[i];
        }
    }
}
