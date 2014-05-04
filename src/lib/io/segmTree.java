package lib.io;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class segmTree {
    private int[] val;
    private int[] elem;
    private final int N;
    private static final int INF = (int) 1e9 + 1;

    public segmTree(int[] a) {
        elem = a;
        N = a.length;
        val = new int[a.length * 4];
        build(0, 0, N);
    }

    void build(int v, int l, int r) {
        if (r - l == 1) {
            val[v] = elem[l];
            return;
        }
        int m = (l + r) / 2;
        build(2 * v + 1, l, m);
        build(2 * v + 2, m, r);
        val[v] = Math.min(val[2 * v + 1], val[2 * v + 2]);
    }

    public void update(int v, int l, int r, int idx, int newVal) {
        if (l > idx || r <= idx) {
            return;
        }
        if (r - l == 1) {
            val[v] = newVal;
            return;
        }

        int m = (l + r) / 2;
        update(2 * v + 1, l, m, idx, newVal);
        update(2 * v + 2, m, r, idx, newVal);
        val[v] = Math.min(val[2 * v + 1], val[2 * v + 2]);
    }

    public int min(int v, int l, int r, int ql, int qr) {
        if (l >= ql && r <= qr) {
            return val[v];
        }
        if (l >= qr || r <= ql) {
            return INF;
        }
        int m = (l + r) / 2;
        int lRes = min(2 * v + 1, l, m, ql, qr);
        int rRes = min(2 * v + 2, m, r, ql, qr);
        return Math.min(lRes, rRes);
    }

}
