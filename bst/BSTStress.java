package main;

import lib.io.Scanner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Zakhar Voit (zakharvoit@gmail.com)
 */
public class BSTStress {
    public static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        Random rnd = new Random(10);
        while (true) {
            StringBuilder builder = new StringBuilder();
            List<Integer> keys = new ArrayList<>();
            for (int i = 0; i < MAX; i++) {
                keys.add(rnd.nextInt(MAX));
            }

            for (int e : keys) {
                builder.append("insert ").append(e).append("\n");
            }

            for (int e : keys) {
                builder.append("prev ").append(e).append("\nnext ").append(e).append("\n");
            }

            for (int e : keys) {
                builder.append("exists ").append(e).append("\n");
            }

            for (int e : keys) {
                if (rnd.nextBoolean()) {
                    builder.append("delete ").append(e).append("\n");
                }
            }


            for (int e : keys) {
                builder.append("prev ").append(e).append("\nnext ").append(e).append("\n");
            }

            for (int e : keys) {
                builder.append("exists ").append(e).append("\n");
            }

            String test = builder.toString();

            InputStream stream = new ByteArrayInputStream(test.getBytes());
            Writer res = new StringWriter();
            PrintWriter out = new PrintWriter(res);
            Scanner in = new Scanner(stream);

            try {
                new bst().solve(1, in, out);
            } catch (Exception e) {
                System.out.println(test);
            }


            String actual = res.toString();
            stream.reset();
            res = new StringWriter();
            out = new PrintWriter(res);
            new TreeSetBST().solve(1, in, out);
            String expected = res.toString();
            if (!expected.equals(actual)) {
                System.out.println("test:\n" + test);
                System.out.println("expected:\n" + expected);
                System.out.println("actual:\n" + actual);
                break;
            }
        }
    }
}