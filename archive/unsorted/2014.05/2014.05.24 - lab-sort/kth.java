package main;

import lib.io.Scanner;
import java.io.PrintWriter;
import java.util.Random;

public class kth {
    public static int n, k;
    public static int a[];
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int  a1 ,a2, A, B, C;
        n = in.nextInt();
        k = in.nextInt();
        A = in.nextInt();
        B = in.nextInt();
        C = in.nextInt();
        a1 = in.nextInt();
        a2 = in.nextInt();

        a = new int[n];
        a[0] = a1;
        a[1] = a2;
        for (int i = 2; i < n; i++) {
            a[i] = A * a[i - 2] + B * a[i - 1] + C;
        }
        k--;
        
        out.print(ordStat(0, n - 1));
    }

    public static int ordStat(int l, int r) {
        if (r <= l + 1) {
                if (r == l + 1 && a[r] < a[l]) {
                    swap(l, r);
             }
                return a[k];
            }

            Random random = new Random();
            int mid = random.nextInt(r - l + 1) + l;
            swap(mid, l + 1);
            if (a[l] > a[r])
                swap(l, r);
            if (a[l + 1] > a[r])
                swap(l + 1, r);
            if (a[l] > a[l + 1])
                swap(l, l + 1);

            int i = l + 1;
            int j = r;
            int curr = a[l + 1];

            while (i <= j) {
                while (a[++i] < curr)
                    ;
                while (a[--j] > curr)
                    ;
                if (i <= j)
                    swap(i, j);
            }
            a[l + 1] = a[j];
            a[j] = curr;
            if (j >= k)
                r = j - 1;
            if (j <= k)
                l = i;
            return ordStat(l, r);
    }

    public static void swap(int x, int y) {
        int curr = a[x];
        a[x] = a[y];
        a[y] = curr;
    }
}
