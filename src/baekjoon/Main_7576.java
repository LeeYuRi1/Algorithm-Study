package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
    static private int[][] a;
    static private int[][] dist;
    static private int[] dx = {0, 0, 1, -1};
    static private int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int m = Integer.parseInt(s1[0]);
        int n = Integer.parseInt(s1[1]);
        a = new int[n][m];
        dist = new int[n][m];
        Queue<Pair_7576> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] s2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(s2[j]);
                dist[i][j] = -1;
                if (a[i][j] == 1) {
                    q.add(new Pair_7576(i, j));
                    dist[i][j] = 0;
                }
            }
        }
        bfs(q, n, m);
        // 얼마나 걸렸는지 알기 위해 dist의 최대값을 구함
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] > ans) ans = dist[i][j];
            }
        }

        // 모두 익지 못하면 -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0 && dist[i][j] == -1) ans = -1;
            }
        }

        System.out.println(ans);
    }

    private static void bfs(Queue<Pair_7576> q, int n, int m) {
        while (!q.isEmpty()) {
            Pair_7576 p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (a[nx][ny] != 0 || dist[nx][ny] != -1) continue;
                q.add(new Pair_7576(nx, ny));
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }
}
