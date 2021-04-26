package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1012 {

    private static int[][] a;
    private static boolean[][] check;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);
            a = new int[n][m];
            check = new boolean[n][m];
            while (k-- > 0) {
                String[] s = br.readLine().split(" ");
                a[Integer.parseInt(s[1])][Integer.parseInt(s[0])] = 1;
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] == 1 && !check[i][j]) {
                        dfs(i, j, n, m);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int x, int y, int n, int m) {
        check[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (a[nx][ny] == 1 && !check[nx][ny]) {
                    dfs(nx, ny, n, m);
                }
            }
        }
    }
}
