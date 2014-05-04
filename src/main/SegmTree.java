package main;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
class SegmTree {
    private long[] val;
    private long[] updSetVal;
    private long[] updAddVal;
    private boolean[] toUpdSet;
    private boolean[] toUpdAdd;
    private long[] elem;
    private int N;
    private final long INF = (long) 1e18 + 1;


    public SegmTree(long[] a) {
        elem = a;
        N = a.length * 4;
        val = new long[N];

        updSetVal = new long[N];
        updAddVal = new long[N];

        toUpdAdd = new boolean[N];
        toUpdSet = new boolean[N];

        build(0, 0, a.length);
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

    void push(int vertex) {
        int l = 2 * vertex + 1;
        int r = 2 * vertex + 2;

        if (l < N) {
            if (toUpdSet[vertex])
                setUpd("set", l, updSetVal[vertex]);
            if (toUpdAdd[vertex])
                setUpd("add", l, updAddVal[vertex]);
        }

        if (r < N) {
            if (toUpdSet[vertex])
                setUpd("set", r, updSetVal[vertex]);
            if (toUpdAdd[vertex])
                setUpd("add", r, updAddVal[vertex]);
        }

        if (toUpdSet[vertex]) {
            val[vertex] = updSetVal[vertex];
            updSetVal[vertex] = 0;
            toUpdSet[vertex] = false;
        }

        if (toUpdAdd[vertex]) {
            val[vertex] += updAddVal[vertex];
            updAddVal[vertex] = 0;
            toUpdAdd[vertex] = false;
        }
    }

    void setUpd(String s, int vertex, long newVal) {
        if (s.equals("set")) {
            updSetVal[vertex] = newVal;
            toUpdSet[vertex] = true;

            updAddVal[vertex] = 0;
            toUpdAdd[vertex] = false;
            return;
        }

        if (toUpdSet[vertex])
            push(vertex);

        updAddVal[vertex] += newVal;
        toUpdAdd[vertex] = true;
    }

    long getVal(int vertex) {
        long result;
        if (toUpdSet[vertex]) {
            result = updSetVal[vertex];
        } else {
            result = val[vertex];
        }

        if (toUpdAdd[vertex]) {
            result += updAddVal[vertex];
        }
        return result;
    }

    public void update(String act, int v, int l, int r, int ql, int qr, long newVal) {
        if (l >= qr || r <= ql) {
            return;
        }

        if (ql <= l && r <= qr) {
            setUpd(act, v, newVal);
            return;
        }

        push(v);

        int m = (l + r) / 2;
        update(act, 2 * v + 1, l, m, ql, qr, newVal);
        update(act, 2 * v + 2, m, r, ql, qr, newVal);

        long lRes = getVal(2 * v + 1);
        long rRes = getVal(2 * v + 2);

        val[v] = Math.min(lRes, rRes);
    }

    public long min(int v, int l, int r, int ql, int qr) {
        if (l >= qr || r <= ql) {
            return INF;
        }

        if (l >= ql && r <= qr) {
            push(v);
            return val[v];
        }

        push(v);

        int m = (l + r) / 2;
        long lRes = min(2 * v + 1, l, m, ql, qr);
        long rRes = min(2 * v + 2, m, r, ql, qr);

        return Math.min(lRes, rRes);
    }

}
