package programmers;

// 땅따먹기
public class Solution_12913 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));
    }

    public static int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = land[i][j];
            }
        }

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    max = Math.max(max, dp[i - 1][k] + dp[i][j]);
                }
                dp[i][j] = max;
            }
        }

        int answer = 0;
        for (int j = 0; j < 4; j++) {
            answer = Math.max(answer, dp[dp.length - 1][j]);
        }
        return answer;
    }
}
