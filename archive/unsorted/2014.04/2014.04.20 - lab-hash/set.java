package main;

import lib.io.MyMap;
import lib.io.Scanner;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class set {
    public void solve(int testNumber, Scanner in, PrintWriter out) {

        String operation;
        int num;
        MyMap S = new MyMap();
        while (true) {
            try {
                operation = in.nextToken();
                num = in.nextInt();

                switch (operation) {
                    case ("insert"):
                        if (!S.exists(num))
                            S.insert(num);
                        break;

                    case ("delete"):
                        if (S.exists(num))
                            S.delete(num);
                        break;

                    case ("exists"):
                        if (S.exists(num))
                            out.println("true");
                        else
                            out.println("false");
                        break;
                }

            } catch (InputMismatchException e) {
                break;
            }
        }
    }
}
