package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2873 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int[][] num = new int[r][c];
        int min = 1000;
        int minX = 1000;
        int minY = 1000;
        for (int i = 0; i < r; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < c; j++) {
                int n = Integer.parseInt(s[j]);
                if ((i + j) % 2 != 0) {
                    if (n < min) {
                        min = n;
                        minX = i;
                        minY = j;
                    }
                }
                num[i][j] = n;
            }
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (r % 2 == 0 && c % 2 == 0) {
            int x1 = 0;
            int x2 = r - 1;
            int y1 = 0;
            int y2 = c - 1;
            while (x2 - x1 > 1) {
                if (x1 / 2 < minX / 2) {
                    add(sb, "R", c - 1);
                    add(sb, "D", 1);
                    add(sb, "L", c - 1);
                    add(sb, "D", 1);
                    x1 += 2;
                }
                if (minX / 2 < x2 / 2) {
                    add(sb2, "R", c - 1);
                    add(sb2, "D", 1);
                    add(sb2, "L", c - 1);
                    add(sb2, "D", 1);
                    x2 -= 2;
                }
            }
            while (y2 - y1 > 1) {
                if (y1 / 2 < minY / 2) {
                    add(sb, "D", 1);
                    add(sb, "R", 1);
                    add(sb, "U", 1);
                    add(sb, "R", 1);
                    y1 += 2;
                }
                if (minY / 2 < y2 / 2) {
                    add(sb2, "D", 1);
                    add(sb2, "R", 1);
                    add(sb2, "U", 1);
                    add(sb2, "R", 1);
                    y2 -= 2;
                }
            }
            //2*2 남은 경우
            if (minY == y1) {
                add(sb, "R", 1);
                add(sb, "D", 1);
            } else {
                add(sb, "D", 1);
                add(sb, "R", 1);
            }
            sb.append(sb2.reverse());
        } else {
            if (r % 2 != 0) {
                String print = "R";
                for (int i = 1; i < r * c; i++) {
                    if (i % c == 0) {
                        sb.append("D");
                        if (print.equals("R")) print = "L";
                        else print = "R";
                    } else sb.append(print);
                }
            } else {
                String print = "D";
                for (int i = 1; i < r * c; i++) {
                    if (i % r == 0) {
                        sb.append("R");
                        if (print.equals("D")) print = "U";
                        else print = "D";
                    } else sb.append(print);
                }
            }
        }
        System.out.println(sb);
    }

    private static void add(StringBuilder sb, String s, int n) {
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
    }
}
