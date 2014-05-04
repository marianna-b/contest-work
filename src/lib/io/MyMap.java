package lib.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Marianna Bisyarina (bisyarinamariashka@gmail.com)
 */
public class MyMap implements Iterable<String> {
    @SuppressWarnings("unchecked")
    private LinkedList<String>[] elements = new LinkedList[255];
    private int size = 0;


    public void put(String y) {
        checkSize();
        int idx = hash(y);

        if (elements[idx] == null) {
            elements[idx] = new LinkedList<>();
        }

        for (String node : elements[idx]) {
            if (node.equals(y)) {
                return;
            }
        }

        size++;
        elements[idx].add(y);
    }

    public void delete(String y) {
        int idx = hash(y);

        if (elements[idx] != null)
            for (Iterator<String> it = elements[idx].iterator(); it.hasNext(); ) {
                String node = it.next();
                if (node.equals(y)) {
                    it.remove();
                    size--;
                    return;
                }
            }
    }

    public ArrayList<String> get() {
        ArrayList<String> result = new ArrayList<>();

        for (LinkedList<String> element : elements)
            if (element != null)
                for (String anElement : element) result.add(anElement);

        return result;
    }

    private void checkSize() {
        if (4 * size < 3 * elements.length)
            return;

        LinkedList<String>[] curr = elements;
        //noinspection unchecked
        elements = new LinkedList[2 * curr.length];


        size = 0;
        for (LinkedList<String> aCurr : curr)
            if (aCurr != null)
                for (String anACurr : aCurr) {
                    put(anACurr);
                }
    }


    private int hash(String x) {
        return (x.hashCode() % elements.length + elements.length) % elements.length;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int pos = 0;
            int cnt = 0;
            Iterator<String> it;

            {
                while (pos < elements.length && (elements[pos] == null || elements[pos].isEmpty())) {
                    pos++;
                }

                if (pos < elements.length) {
                    it = elements[pos++].iterator();
                }
            }

            @Override
            public boolean hasNext() {
                return cnt < size;
            }

            @Override
            public String next() {
                if (!it.hasNext()) {
                    while (elements[pos] == null || elements[pos].isEmpty()) {
                        pos++;
                    }
                    it = elements[pos++].iterator();
                }

                cnt++;
                return it.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public int size() {
        return size;
    }
}
