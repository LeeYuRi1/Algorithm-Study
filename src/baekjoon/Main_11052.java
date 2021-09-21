package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] card = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            card[i] = Integer.parseInt(input[i - 1]);
        }

        dp[1] = card[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = card[i];
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
            }
        }
        System.out.println(dp[n]);
    }
}
