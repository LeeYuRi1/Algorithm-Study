package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n + 1];
            for (int i = 0; i < 2; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 1; j <= n; j++) {
                    sticker[i][j] = Integer.parseInt(input[j - 1]);
                }
            }
            int[][] dp = new int[2][n + 1];
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];
            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
            }
            sb.append(Math.max(dp[0][n], dp[1][n]) + "\n");
        }
        System.out.println(sb);
    }
}
