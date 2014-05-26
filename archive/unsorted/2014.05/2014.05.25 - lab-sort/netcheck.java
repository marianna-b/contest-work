package main;





import lib.io.Scanner;
import java.io.PrintWriter;

public class netcheck {
    public static int n, m, k;
    public static int[][] a;
    public static int[] r;
    public static int perm[];

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        r = new int[k];
        a = new int[k][2 * m];

        for (int i = 0; i < k; i++) {
           r[i] = in.nextInt();

            for (int j = 0; j < 2 * r[i]; j++)
                a[i][j] = in.nextInt();
        }
        int mVal = 1;
        for (int i = 0; i < n; i++)
            mVal *= 2;

        boolean f = false;
        for (int i = 0; i < mVal; i++) {
            getPerm(i);
            if (!check()) {
                f = true;
                break;
            }
        }
        if (f)
            out.println("No");
        else
            out.println("Yes");
    }

    public static boolean check() {
        int g, h, x;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 2 * r[i]; j+= 2) {
                g = Math.min(a[i][j], a[i][j + 1]) - 1;
                h = Math.max(a[i][j], a[i][j + 1]) - 1;

                x = Math.min(perm[g], perm[h]);
                perm[h] = Math.max(perm[g], perm[h]);
                perm[g] = x;
            }
        }
        for (int i = 1; i < n; i++) {
            if (perm[i] < perm[i - 1])
                return false;
        }
        return true;
    }

    public static void getPerm(int val) {
        perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = val % 2;
            val /= 2;
        }
    }
}
