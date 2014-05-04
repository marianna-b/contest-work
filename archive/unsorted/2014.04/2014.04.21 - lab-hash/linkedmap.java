package main;


import lib.io.MyMap;
import lib.io.Scanner;

import java.io.PrintWriter;
import java.util.InputMismatchException;

public class linkedmap {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String operation, val, key;
        MyMap S = new MyMap();

        while (true) {
            try {
                operation = in.nextToken();
                key = in.nextToken();
            } catch (InputMismatchException e) {
                break;
            }

            switch (operation) {
                case ("put"):
                    val = in.nextToken();
                    S.put(key, val);
                    break;
                case ("delete"):
                    S.delete(key);
                    break;
                case ("get"):
                    String res = S.get(key);
                    out.println(res);
                    break;
                case ("prev"):
                    String previous = S.prev(key);
                    out.println(previous);
                    break;
                case ("next"):
                    String next = S.next(key);
                    out.println(next);
                    break;
            }
        }
    }
}
