package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2630 {
    private static int[][] paper;
    private static int white = 0;
    private static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(input[j]);
            }
        }
        divide(0, 0, n);
        System.out.println(white + "\n" + blue);
    }

    private static void divide(int x, int y, int m) {
        if (check(x, y, m)) return;
        divide(x, y, m / 2);
        divide(x + m / 2, y, m / 2);
        divide(x, y + m / 2, m / 2);
        divide(x + m / 2, y + m / 2, m / 2);
    }

    private static boolean check(int x, int y, int m) {
        int origin = paper[x][y];
        for (int i = x; i < x + m; i++) {
            for (int j = y; j < y + m; j++) {
                if (origin != paper[i][j]) return false;
            }
        }
        if (origin == 0) white++;
        else blue++;
        return true;
    }
}
