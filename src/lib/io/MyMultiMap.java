package lib.io;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class MyMultiMap {
    private static final int SIZE = 1_00_007;
    @SuppressWarnings("unchecked")
    private LinkedList<MultiNode>[] maps = new LinkedList[SIZE];

    public void put(String x, String y) {
        int idx = hash(x);

        if (maps[idx] == null)
            maps[idx] = new LinkedList<>();

        for (MultiNode node : maps[idx]) {
            if (node.x.equals(x)) {
                node.elements.put(y);
                return;
            }
        }

        MultiNode t = new MultiNode(x);
        t.elements.put(y);
        maps[idx].add(t);
    }

    public void deleteall(String x) {
        int idx = hash(x);

        if (maps[idx] == null)
            return;

        for (Iterator<MultiNode> it = maps[idx].iterator(); it.hasNext(); ) {
            MultiNode node = it.next();
            if (node.x.equals(x)) {
                it.remove();
                return;
            }
        }
    }

    public void delete(String x, String y) {
        int idx = hash(x);

        if (maps[idx] == null)
            return;

        for (MultiNode node : maps[idx]) {
            if (node.x.equals(x)) {
                node.elements.delete(y);
                return;
            }
        }
    }

    public MyMap get(String x) {
        int idx = hash(x);

        if (maps[idx] == null) {
            return null;
        }

        for (MultiNode node : maps[idx]) {
            if (node.x.equals(x)) {
                return node.elements;
            }
        }

        return null;
    }


    private int hash(String x) {
        return (x.hashCode() % SIZE + SIZE) % SIZE;
    }

    class MultiNode {
        private MyMap elements;
        private String x;

        MultiNode(String a) {
            elements = new MyMap();
            x = a;
        }
    }
}
