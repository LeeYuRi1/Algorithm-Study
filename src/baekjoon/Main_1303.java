package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1303 {
    private static int[][] arr;
    private static boolean[][] check;
    private static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[1]);
        m = Integer.parseInt(s[0]);
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s2 = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if (s2[j].equals("W")) arr[i][j] = 0;
                else arr[i][j] = 1;
            }
        }

        for (int k = 0; k < 2; k++) {
            check = new boolean[n][m];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!check[i][j] && arr[i][j] == k) ans += Math.pow(bfs(i, j, k), 2);
                }
            }
            System.out.print(ans + " ");
        }
    }

    private static int bfs(int x, int y, int k) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        check[x][y] = true;
        int num = 1;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (check[nx][ny] || arr[nx][ny] != k) continue;
                queue.offer(new int[]{nx, ny});
                check[nx][ny] = true;
                num++;
            }
        }
        return num;
    }
}
