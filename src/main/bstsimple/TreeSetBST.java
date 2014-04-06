package main.bstsimple;

import lib.io.Scanner;

import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.TreeMap;

public class TreeSetBST {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        TreeMap<Integer, Object> bst = new TreeMap<>();

        while (true) {
            String command;
            try {
                command = in.nextToken();
            } catch (InputMismatchException e) {
                return;
            }

            int value = in.nextInt();
            Integer res;

            switch (command) {
                case "insert":
                    bst.put(value, null);
                    break;
                case "delete":
                    bst.remove(value);
                    break;
                case "exists":
                    out.println(bst.containsKey(value));
                    break;
                case "next":
                    res = bst.higherKey(value);
                    out.println(res == null ? "none" : res);
                    break;
                case "prev":
                    res = bst.lowerKey(value);
                    out.println(res == null ? "none" : res);
                    break;
            }
        }
    }
}