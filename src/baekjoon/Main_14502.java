package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_14502 {
    private static int n, m, ans = 0;
    private static int[][] arr;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input2[j]);
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
                if (arr[i][j] != 0) continue;
                arr[i][j] = 1;
                backtracking(depth + 1);
                arr[i][j] = 0;
            }
        }
    }

    private static void bfs() {
        int[][] temp = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = arr[i][j];
                if (temp[i][j] == 2) queue.offer(new int[]{i, j});
                if (temp[i][j] > 0) count++;
            }
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (temp[nx][ny] != 0) continue;
                temp[nx][ny] = 1;
                queue.offer(new int[]{nx, ny});
                count++;
            }
        }
        ans = Math.max(ans, (n * m) - count);
    }
}
