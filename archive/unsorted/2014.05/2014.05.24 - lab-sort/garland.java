package main;

import lib.io.Scanner;
import java.io.PrintWriter;

public class garland {
    public static int n;
    public  static double A;
    public static final double eps = 1e-5;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        A = in.nextDouble();

        double result = ans(binsearch(0, A));
        result = result * 100;
        result = (double)((int) result);
        result = result / 100;
        out.println(result);
    }

    public static double binsearch(double l, double r) {
        if (r - l < eps)
            return r;
        double m = (l + r) / 2;
        if (check(m))
            return binsearch(l, m);
        else
            return binsearch(m, r);
    }

    public static boolean check(double B) {
        double curr = B;
        double prev = A;
        double new_elem;
        for (int i = 2; i < n; i++) {
            new_elem = curr * (double)2 + (double)2 - prev;
            if (new_elem < eps)
                return false;
            prev = curr;
            curr = new_elem;
        }
        return true;
    }

    public static double ans(double B) {
        double curr = B;
        double prev = A;
        double new_elem;
        for (int i = 2; i < n; i++) {
            new_elem = curr * (double)2 + (double)2 - prev;
            prev = curr;
            curr = new_elem;
        }
        return curr;
    }
}
