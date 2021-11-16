package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] area = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(input[j]);
            }
        }

        long[][] dp = new long[n][n];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1) continue;
                int k = area[i][j];
                if (i + k < n) dp[i + k][j] += dp[i][j];
                if (j + k < n) dp[i][j + k] += dp[i][j];
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}
