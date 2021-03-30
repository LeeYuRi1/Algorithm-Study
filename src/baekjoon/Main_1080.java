package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1080 {

    private static int[][] a;
    private static int[][] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        a = new int[n][m];
        b = new int[n][m];
        int result = 0;

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(s[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                b[i][j] = Integer.parseInt(s[j]);
            }
        }

        if (n < 3 || m < 3) {
            System.out.println(check(n, m));
            return;
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (a[i][j] != b[i][j]) {
                    change(i, j);
                    result++;
                }
            }
        }

        if (check(n, m) == -1) result = -1;
        System.out.println(result);
    }

    private static void change(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (a[i][j] == 0) a[i][j] = 1;
                else a[i][j] = 0;
            }
        }
    }

    private static int check(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
