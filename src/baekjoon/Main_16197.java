package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_16197 {
    private static int n, m;
    private static boolean ans;
    private static String[][] board;
    private static List<int[]> coin = new ArrayList<>();
    private static int[] arr;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);
        board = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = input2[j];
                if (board[i][j].equals("o")) coin.add(new int[]{i, j});
            }
        }
        for (int i = 1; i <= 10; i++) {
            ans = false;
            arr = new int[i];
            dfs(i, 0);
            if (ans) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    private static void dfs(int n, int depth) {
        if (depth == n) {
            check();
            return;
        }
        for (int i = 0; i < 4; i++) {
            arr[depth] = i;
            dfs(n, depth + 1);
        }
    }

    private static void check() {
        int result = 0;
        int[][] move = new int[2][2];
        for (int i = 0; i < 2; i++) {
            move[i][0] = coin.get(i)[0];
            move[i][1] = coin.get(i)[1];
        }
        for (int i : arr) {
            for (int j = 0; j < 2; j++) {
                int x = move[j][0] + dx[i];
                int y = move[j][1] + dy[i];
                if (x < 0 || x >= n || y < 0 || y >= m) {
                    result++;
                    continue;
                }
                if (!board[x][y].equals("#")) {
                    move[j][0] = x;
                    move[j][1] = y;
                }
            }
        }
        if (result == 1) ans = true;
    }
}
