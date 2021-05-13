package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1389 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] g = new int[n + 1][n + 1];
        int inf = 100000000;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) g[i][j] = 0;
                else g[i][j] = inf;
            }
        }

        while (m-- > 0) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            g[a][b] = 1;
            g[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (g[i][j] > g[i][k] + g[k][j]) {
                        g[i][j] = g[i][k] + g[k][j];
                    }
                }
            }
        }

        int min = 100000000;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += g[i][j];
            }
            if (min > sum) {
                min = sum;
                ans = i;
            }
        }
        System.out.println(ans);
    }
}
