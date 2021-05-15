package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair_7569 {
    int h;
    int x;
    int y;

    Pair_7569(int h, int x, int y) {
        this.h = h;
        this.x = x;
        this.y = y;
    }
}

public class Main_7569 {
    static private int[][][] a;
    static private int[][][] dist;
    static private int[] dh = {0, 0, 0, 0, 1, -1};
    static private int[] dx = {0, 0, 1, -1, 0, 0};
    static private int[] dy = {1, -1, 0, 0, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int h = Integer.parseInt(input[2]);

        a = new int[h][n][m];
        dist = new int[h][n][m];
        Queue<Pair_7569> queue = new LinkedList<>();
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                String[] input2 = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    a[k][i][j] = Integer.parseInt(input2[j]);
                    dist[k][i][j] = -1;
                    if (a[k][i][j] == 1) {
                        dist[k][i][j] = 0;
                        queue.add(new Pair_7569(k, i, j));
                    }
                }
            }
        }
        bfs(queue, h, n, m);
        int ans = 0;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[k][i][j] == 0 && dist[k][i][j] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    if (dist[k][i][j] > ans) ans = dist[k][i][j];
                }
            }
        }
        System.out.println(ans);
    }

    private static void bfs(Queue<Pair_7569> queue, int k, int n, int m) {
        while (!queue.isEmpty()) {
            Pair_7569 p = queue.poll();
            int h = p.h;
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < 6; i++) {
                int nh = h + dh[i];
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nh && nh < k && 0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (a[nh][nx][ny] == 0 && dist[nh][nx][ny] == -1) {
                        queue.add(new Pair_7569(nh, nx, ny));
                        dist[nh][nx][ny] = dist[h][x][y] + 1;
                    }
                }
            }
        }
    }
}
