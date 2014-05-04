package main;

import lib.io.MyMap;
import lib.io.Scanner;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class linkedmap {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String operation, val, key;
        String res = "";
        MyMap S = new MyMap();

        while (true) {
            try {
                operation = in.nextToken();
                key = in.nextToken();
                switch (operation) {
                    case ("put"):
                        val = in.nextToken();
                        S.put(key, val);
                        break;
                    case ("delete"):
                        S.delete(key);
                        break;
                    case ("get"):
                        res = S.get(key);
                        out.println(res);
                        break;
                    case ("prev"):
                        res = S.prev(key);
                        out.println(res);
                        break;
                    case ("next"):
                        res = S.next(key);
                        out.println(res);
                        break;
                }
            } catch (InputMismatchException e) {
                break;
            }


        }
    }
}
