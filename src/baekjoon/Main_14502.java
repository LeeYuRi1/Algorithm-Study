package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_14502 {
    private static int n, m;
    private static int[][] area;
    private static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        area = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                area[i][j] = Integer.parseInt(s2[j]);
            }
        }
        backtracking(0);
        System.out.println(ans);
    }

    private static void backtracking(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (area[i][j] == 0) {
                    area[i][j] = 1;
                    backtracking(depth + 1);
                    area[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = area[i][j];
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 2) queue.add(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (temp[nx][ny] == 0) {
                    temp[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        check(temp);
    }

    private static void check(int[][] temp) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) result++;
            }
        }
        ans = Math.max(ans, result);
    }
}
