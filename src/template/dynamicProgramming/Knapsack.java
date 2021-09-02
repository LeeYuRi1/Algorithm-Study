package template.dynamicProgramming;

public class Knapsack {
    public static void main(String[] args) {
        int n = 4; // 물품의 수
        int k = 7; // 버틸 수 있는 무게
        int[] w = {0, 6, 4, 3, 5}; // 각 물건의 무게
        int[] v = {0, 13, 8, 6, 12}; // 각 물건의 가치
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (w[i] > j) { // i번째 무게를 더 담을 수 없는 경우
                    dp[i][j] = dp[i - 1][j];
                } else { // i번째 무게를 더 담을 수 있는 경우
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
