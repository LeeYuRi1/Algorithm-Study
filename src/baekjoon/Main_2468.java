package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2468 {

    private static int[][] a;
    private static boolean[][] check;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(s[j]);
                a[i][j] = num;
                if (num > max) max = num;
            }
        }

        int ans = 0;
        for (int h = 0; h <= max; h++) {
            int count = 0;
            check = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i][j] >= h && !check[i][j]) {
                        dfs(i, j, n, h);
                        count++;
                    }
                }
            }
            if (count > ans) ans = count;
        }
        System.out.println(ans);
    }

    private static void dfs(int x, int y, int n, int h) {
        check[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (a[nx][ny] >= h && !check[nx][ny]) {
                    dfs(nx, ny, n, h);
                }
            }
        }
    }
}
