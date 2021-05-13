package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 플로이드 결과가 주어졌을 때 간선 개수의 최소값, 합 구하기
public class Main_1507 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] g = new int[n + 1][n + 1];
        boolean[][] check = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                g[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        // i에서 j로 가는 비용이 x일 때, i-k-j로 가는 비용이 x면 i-j로 가는 도로는 필요없음
        // 모든 쌍을 보면서 필요없는 간선 제거
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (i == k) continue;
                for (int j = 1; j <= n; j++) {
                    if (i == j || k == j) continue;
                    if (g[i][j] > g[i][k] + g[k][j]) {
                        System.out.println(-1);
                        return;
                    }
                    if (g[i][j] == g[i][k] + g[k][j]) {
                        check[i][j] = true;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!check[i][j]) ans += g[i][j];
            }
        }
        System.out.println(ans / 2);
    }
}
