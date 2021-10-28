package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1149 {
    private static int[][] dp;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.parseInt(input[j]);
            }
        }
        findMin();
        System.out.println(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
    }

    private static void findMin() {
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i][0] + dp[i - 1][1], dp[i][0] + dp[i - 1][2]);
            dp[i][1] = Math.min(dp[i][1] + dp[i - 1][0], dp[i][1] + dp[i - 1][2]);
            dp[i][2] = Math.min(dp[i][2] + dp[i - 1][0], dp[i][2] + dp[i - 1][1]);
        }
    }
}
