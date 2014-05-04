package main;

import lib.io.MyMap;
import lib.io.MyMultiMap;
import lib.io.Scanner;

import java.io.PrintWriter;
import java.util.InputMismatchException;

public class multimap {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String operation, val, key;
        MyMultiMap S = new MyMultiMap();

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
                    val = in.nextToken();
                    S.delete(key, val);
                    break;
                case ("deleteall"):
                    S.deleteall(key);
                    break;
                case ("get"):
                    MyMap res = S.get(key);
                    if (res == null) {
                        out.println("0");
                    } else {
                        out.print(res.size());
                        out.print(" ");
                        for (String cur : res) {
                            out.print(cur);
                            out.print(" ");
                        }
                        out.println();
                    }
                    break;
            }
        }
    }
}

