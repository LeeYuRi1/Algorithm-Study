package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15684 {
    private static int[][] ladders;
    private static int n, h, ans = 0;
    private static boolean finish = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        h = Integer.parseInt(input1[2]);
        ladders = new int[h][n];
        while (m-- > 0) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]) - 1;
            int b = Integer.parseInt(input2[1]) - 1;
            ladders[a][b] = 1; // 오른쪽으로 이동
            ladders[a][b + 1] = -1; // 왼쪽으로 이동
        }
        for (int i = 0; i <= 3; i++) {
            ans = i;
            dfs(0, 0);
            if (finish) break;
        }
        if (!finish) ans = -1;
        System.out.println(ans);
    }

    private static void dfs(int start, int depth) {
        if (finish) return;
        if (depth == ans) {
            if (check()) finish = true;
            return;
        }
        for (int i = start; i < h; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (ladders[i][j] != 0 || ladders[i][j + 1] != 0) continue;
                ladders[i][j] = 1;
                ladders[i][j + 1] = -1;
                dfs(i, depth + 1);
                ladders[i][j] = ladders[i][j + 1] = 0;
            }
        }
    }

    private static boolean check() {
        for (int j = 0; j < n; j++) {
            int now = j;
            for (int i = 0; i < h; i++) {
                if (ladders[i][now] == 1) now++;
                else if (ladders[i][now] == -1) now--;
            }
            if (now != j) return false;
        }
        return true;
    }
}
