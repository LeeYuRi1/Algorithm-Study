package samsung;

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
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int nextT = i + time[i]; // 현재 + 상담일
            if (nextT <= n) dp[nextT] = Math.max(dp[nextT], dp[i] + price[i]); // 범위를 초과하지 않으면 금액을 더해줌
            dp[i + 1] = Math.max(dp[i], dp[i + 1]); // 금액 유지
        }
        System.out.println(dp[n]);
    }
}
