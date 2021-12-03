package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1080 {
    private static int n, m;
    private static int[][] a;
    private static int[][] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        a = new int[n][m];
        b = new int[n][m];
        for (int i = 0; i < n * 2; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if (i < n) a[i][j] = Integer.parseInt(s[j]);
                else b[i - n][j] = Integer.parseInt(s[j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (a[i][j] == b[i][j]) continue;
                convert(a, i, j);
                ans++;
            }
        }
        System.out.println(check() ? ans : -1);
    }

    private static void convert(int[][] a, int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (a[i][j] == 0) a[i][j] = 1;
                else a[i][j] = 0;
            }
        }
    }

    private static boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
}
