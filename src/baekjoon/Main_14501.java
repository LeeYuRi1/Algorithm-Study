package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n];
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            time[i] = Integer.parseInt(input[0]);
            price[i] = Integer.parseInt(input[1]);
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = price[i];
            for (int j = 0; j < i; j++) {
                if (j + time[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[j] + price[i]);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i + time[i] < n + 1) ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
