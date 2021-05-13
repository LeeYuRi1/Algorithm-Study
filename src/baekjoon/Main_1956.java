package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 그래프에서 사이클 길이 중 최소 길이 찾기
// 플로이드 후에 g[i][i] 검사
public class Main_1956 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        int[][] g = new int[v + 1][v + 1];
        int inf = 100000000;
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                g[i][j] = inf;
            }
        }
        while (e-- > 0) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            int c = Integer.parseInt(input2[2]);
            g[a][b] = c;
        }

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (g[i][j] > g[i][k] + g[k][j]) {
                        g[i][j] = g[i][k] + g[k][j];
                    }
                }
            }
        }

        int ans = inf;
        for (int i = 1; i <= v; i++) {
            if (ans > g[i][i]) ans = g[i][i];
        }
        if (ans == inf) System.out.println(-1);
        else System.out.println(ans);
    }
}
