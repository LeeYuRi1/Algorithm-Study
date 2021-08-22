package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair_7576 {
    int x;
    int y;

    Pair_7576(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_7576 {
    private static int n, m;
    static private int[][] arr;
    static private int[][] dist;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        m = Integer.parseInt(s1[0]);
        n = Integer.parseInt(s1[1]);
        arr = new int[n][m];
        dist = new int[n][m];
        Queue<Pair_7576> queue = new LinkedList<>();
        for (int[] i : dist) Arrays.fill(i, -1);
        for (int i = 0; i < n; i++) {
            String[] s2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s2[j]);
                if (arr[i][j] == 1) {
                    queue.offer(new Pair_7576(i, j));
                    dist[i][j] = 0;
                }
            }
        }
        bfs(queue);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 && dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                ans = Math.max(ans, dist[i][j]);
            }
        }
        System.out.println(ans);
    }

    private static void bfs(Queue<Pair_7576> queue) {
        while (!queue.isEmpty()) {
            Pair_7576 p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (arr[nx][ny] != 0 || dist[nx][ny] != -1) continue;
                queue.add(new Pair_7576(nx, ny));
                dist[nx][ny] = dist[p.x][p.y] + 1;
            }
        }
    }
}
