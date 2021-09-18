package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        int[] dp = new int[n];
        dp[0] = a[0];
        for (int i = 1; i < n; i++) {
            dp[i] = a[i];
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) dp[i] = Math.max(dp[i], dp[j] + a[i]);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
