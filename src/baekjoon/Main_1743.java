package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1743 {
    private static int[][] arr;
    private static boolean[][] check;
    private static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        int k = Integer.parseInt(s1[2]);
        arr = new int[n][m];
        check = new boolean[n][m];

        while (k-- > 0) {
            String[] s2 = br.readLine().split(" ");
            int r = Integer.parseInt(s2[0]) - 1;
            int c = Integer.parseInt(s2[1]) - 1;
            arr[r][c] = 1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j] && arr[i][j] == 1) ans = Math.max(ans, bfs(i, j));
            }
        }
        System.out.println(ans);
    }

    private static int bfs(int x, int y) {
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
                if (check[nx][ny] || arr[nx][ny] == 0) continue;
                queue.offer(new int[]{nx, ny});
                check[nx][ny] = true;
                num++;
            }
        }
        return num;
    }
}
