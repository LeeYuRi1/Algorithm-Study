package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_18405 {
    private static int[][] area;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        area = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s2 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(s2[j]);
            }
        }
        String[] s3 = br.readLine().split(" ");
        int s = Integer.parseInt(s3[0]);
        int x = Integer.parseInt(s3[1]) - 1;
        int y = Integer.parseInt(s3[2]) - 1;
        //s초까지 1초마다 1부터 k까지 바이러스를 증식시킴
        for (int i = 0; i < s; i++) {
            for (int j = 1; j <= k; j++) {
                bfs(n, j);
                if (area[x][y] != 0) {
                    System.out.println(area[x][y]);
                    return;
                }
            }
        }
        System.out.println(0);
    }

    private static void bfs(int n, int v) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (area[i][j] == v) queue.offer(new int[]{i, j});
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (area[nx][ny] != 0) continue;
                area[nx][ny] = v;
            }
        }
    }
}
