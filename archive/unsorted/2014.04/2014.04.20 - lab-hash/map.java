package main;



import lib.io.MyMap;
import lib.io.Scanner;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class map {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String operation;
        String key, value;
        MyMap S = new MyMap();
        while (true) {
            try {
                operation = in.nextToken();
                key = in.nextToken();

                switch (operation) {
                    case ("put"):
                        value = in.nextToken();
                        S.put(key, value);
                        break;

                    case ("delete"):

                        S.delete(key);
                        break;

                    case ("get"):
                        out.println(S.get(key));
                }

            } catch (InputMismatchException e) {
                break;
            }
        }
    }
}
