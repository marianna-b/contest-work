package main;

import lib.io.Scanner;

import java.io.PrintWriter;
import java.util.InputMismatchException;

public class dsu {
    public void solve(int testNumber, Scanner in, PrintWriter out) {

        int n = in.nextInt();

        Member[] set = new Member[n + 1];

        for (int i = 1; i <= n; i++) {
            set[i] = new Member();
            set[i].init(i);
        }

        int x, y;
        Member currX, currY;
        String operation;
        while (true) {
            try {
                operation = in.nextToken();

                if (operation.charAt(0) == 'u') {
                    x = in.nextInt();
                    y = in.nextInt();

                    currX = set[x].get();
                    currY = set[y].get();

                    union(currX, currY);
                } else {
                    x = in.nextInt();
                    set[x].get();

                    currX = set[x].get();
                    out.println(currX.minElem + " " + currX.maxElem + " " + currX.number);
                }

            } catch (InputMismatchException e) {
                break;
            }
        }

    }


    public void union(Member x, Member y) {
        if (x.equals(y))
            return;

        if (x.number > y.number) {
            y.parent = x;
            x.maxElem = Math.max(x.maxElem, y.maxElem);
            x.minElem = Math.min(x.minElem, y.minElem);
            x.number = x.number + y.number;
        } else {
            x.parent = y;
            y.maxElem = Math.max(x.maxElem, y.maxElem);
            y.minElem = Math.min(x.minElem, y.minElem);
            y.number = x.number + y.number;
        }
    }

    public class Member {
        Member parent;
       int number, minElem, maxElem;

        public void init(int x) {
            parent = this;
            number = 1;
            minElem = x;
            maxElem = x;
        }

        public Member get() {
            if (parent != this) {
                parent = parent.get();
            }
            return parent;
        }

    }
}
