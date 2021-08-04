package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11403 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] g = new int[n][n];
        int inf = 100000;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(input[j]);
                if (x == 0) g[i][j] = inf;
                else g[i][j] = x;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (g[i][j] > g[i][k] + g[k][j]) {
                        g[i][j] = g[i][k] + g[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == inf) sb.append("0 ");
                else sb.append("1 ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
