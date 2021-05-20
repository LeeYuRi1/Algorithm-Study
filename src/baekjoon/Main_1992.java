package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1992 {
    private static int[][] num;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        num = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                num[i][j] = Integer.parseInt(s[j]);
            }
        }
        quadTree(0, 0, n);
        System.out.println(sb);
    }

    private static void quadTree(int x, int y, int k) {
        int l = k / 2;
        if (check(x, y, k)) {
            sb.append(num[x][y]);
        } else {
            sb.append("(");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    quadTree(x + i * l, y + j * l, l);
                }
            }
            sb.append(")");
        }
    }

    private static boolean check(int x, int y, int k) {
        int n = num[x][y];
        for (int i = x; i < x + k; i++) {
            for (int j = y; j < y + k; j++) {
                if (num[i][j] != n) return false;
            }
        }
        return true;
    }
}
