package main;

import lib.io.Scanner;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NavigableSet;
import java.util.TreeSet;

public class priorityqueue {
    public static ArrayList <Vertex> heap = new ArrayList<Vertex>();
    public static ArrayList <Integer> addings = new ArrayList<Integer>();
    public static final int INF = (int)1e9 + 1;

    public void solve(int testNumber, Scanner in, PrintWriter out) {

        String operation;
        int x, y;
        int num = 1;
        addings.add(-1);

        while (true) {
            try {
                operation = in.nextToken();
                addings.add(heap.size());

                if (operation.equals("decrease-key")) {
                    x = in.nextInt();
                    y = in.nextInt();

                    decreaseKey(y, addings.get(x));
                } else if (operation.equals("extract-min")) {
                    if (heap.size() > 0) {
                        out.println(extractMin());
                    } else {
                        out.println('*');
                    }
                } else {
                    x = in.nextInt();

                    Vertex newElem = new Vertex(x, num);
                    push(newElem);
                }

                num++;
            } catch (InputMismatchException e) {
                break;
            }
        }
    }

    public static void decreaseKey(int x, int y) {

        Vertex curr = heap.get(y);
        curr.value = x;

        siftUp(y);
    }

    public static void push(Vertex elem)
    {
        heap.add(elem);

        siftUp(heap.size() - 1);
    }

    public static int extractMin() {
        int result = heap.get(0).value;

        Vertex curr = heap.get(heap.size() - 1);

        heap.set(0, curr);
        heap.remove(heap.size() - 1);

        addings.set(curr.operation, 0);

        if (!heap.isEmpty())
            siftDown(0);

        return result;
    }

    public static void siftDown(int x) {
        int left = INF, right = INF;

        if (2 * x + 1 < heap.size()) {
            left = heap.get(2 * x + 1).value;
        }

        if (2 * x + 2 < heap.size()) {
            right = heap.get(2 * x + 2).value;
        }

        int curr = heap.get(x).value;
        if (left > curr && right > curr) {
            return;
        }

        int pos;
        if (right < left) {
            pos = 2 * x + 2;
        } else {
            pos = 2 * x + 1;
        }

        Vertex elem = heap.get(x);

        heap.set(x, heap.get(pos));
        heap.set(pos, elem);

        addings.set(heap.get(x).operation, x);
        addings.set(heap.get(pos).operation, pos);

        siftDown(pos);
    }

    public static void siftUp(int x) {
        if (x == 0)
            return;

        int parent = heap.get((x - 1) / 2).value;
        int curr = heap.get(x).value;

        if (curr < parent) {
            Vertex elem = heap.get(x);

            heap.set(x, heap.get((x - 1) / 2));
            heap.set((x - 1) / 2, elem);

            addings.set(heap.get(x).operation, x);
            addings.set(heap.get((x - 1) / 2).operation, (x - 1) / 2);

            siftUp((x - 1) / 2);
        }
    }

    public class Vertex {
        int value, operation;

        public Vertex(int v, int o) {
            value = v;
            operation = o;
        }
    }
}
