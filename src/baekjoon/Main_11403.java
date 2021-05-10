package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11403 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][n];
        int inf = 100000;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(input[j]);
                if (x == 0) a[i][j] = inf;
                else a[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i][j] > a[i][k] + a[k][j]) {
                        a[i][j] = a[i][k] + a[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == inf) sb.append("0 ");
                else sb.append("1 ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
