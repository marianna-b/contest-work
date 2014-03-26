package main;



import lib.io.Scanner;

import java.io.PrintWriter;

public class parking {
    public static final int INF = (int)1e6;

    public void solve(int testNumber, Scanner in, PrintWriter out) {

        int n = in.nextInt();

        Dsu parking = new Dsu(n);

        for (int i = 0; i < n; i++) {
            parking.tree[i] = new Member(i);
        }
        for (int i = 0; i < n; i++) {
            parking.tree[i].nextZero = parking.tree[(i + 1) % n];
        }

        int x;
        for (int i = 0; i < n; i++) {
           x = in.nextInt();
            x--;

            if (parking.tree[x].empty) {

                out.print((x + 1) + " ");
                parking.tree[x].empty = false;

            } else {
                Member currParent = parking.tree[x].get();
                Member result = currParent.getNextZero();

                out.print((result.val + 1) + " ");

                result.empty = false;
                result.union(currParent);
            }
        }
    }

    public class Dsu {
    Member[] tree;

        public Dsu(int x) {
            tree = new Member[x + 1];
        }
    }

    public class Member {
        int val;
        Member parent, nextZero;
        boolean empty;

        public Member(int num) {
            val = num;
            empty = true;
            parent = this;
        }

        public Member get() {
            if (parent != this) {
                parent = parent.get();
            }
            return parent;
        }

        public Member getNextZero() {
            if (!nextZero.empty) {
                nextZero.union(this);
                nextZero.getNextZero();
            }
            return nextZero;
        }

        public void union(Member x) {
            if (x.equals(this))
                return;

            x.parent = this;
        }
    }

}
