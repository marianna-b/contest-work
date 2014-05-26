package main;

import lib.io.Scanner;
import java.io.PrintWriter;

public class radixsort {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        String[] A = new String[n];

        for (int i = 0; i < n; i++) {
            A[i] = in.next();
        }

        String[] B = new String[n];
        int[] C = new int[26];
        for (int i = 1; i <= k; i++) {
            int idx = m - i;
            for (int j = 0; j < 26; j++) {
                C[j] = 0;
            }
            for (int j = 0; j < n; j++) {
                int d = A[j].charAt(idx) - 'a';
                C[d]++;
            }
            int count = 0;
            for (int j = 0; j < 26; j++) {
                int tmp = C[j];
                C[j] = count;
                count += tmp;
            }
            for (int j = 0; j < n; j++) {
                int d = A[j].charAt(idx) - 'a';
                B[C[d]] = A[j];
                C[d]++;
            }
            System.arraycopy(B, 0, A, 0, n);
        }

        for (int i = 0; i < n; i++) {
            out.println(A[i]);
        }
    }
}
