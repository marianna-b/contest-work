package main;

import lib.io.Scanner;
import java.io.PrintWriter;
import java.util.NavigableSet;
import java.util.TreeSet;

public class parking {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        NavigableSet <Integer> freeSpace = new TreeSet<Integer>();

        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < 2 * n; i++) {
            freeSpace.add(i);
        }

        String action;
        int x;
        for (int i = 0; i < m; i++) {
            action = in.nextToken();
            x = in.nextInt();
            x--;

            if (action.equals("enter")) {
                int result = freeSpace.higher(x);

                if (freeSpace.contains(x)) {
                    result = x;
                }

                if (result >= n) {
                    freeSpace.remove(result - n);
                } else {
                    freeSpace.remove(result + n);
                }

                freeSpace.remove(result);
                out.println((result % n + 1));
            } else {
                freeSpace.add(x);
                freeSpace.add(x + n);
            }
        }
    }
}
