package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// dfs로 문제를 풀 수 없음. bfs 사용 (단계별로 진행)
// 모든 가중치가 1이면 최단거리 알고리즘을 bfs로 구할 수 있음
class Pair_2178 {
    int x;
    int y;

    Pair_2178(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_2178 {

    static private int[][] a;
    static private int[][] dist;
    static private int[] dx = {0, 0, 1, -1};
    static private int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        a = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(s1[j]);
            }
        }
        bfs(n, m);
        System.out.println(dist[n - 1][m - 1]);
    }

    private static void bfs(int n, int m) {
        Queue<Pair_2178> q = new LinkedList<>();
        q.add(new Pair_2178(0, 0));
        dist[0][0] = 1;
        while (!q.isEmpty()) {
            Pair_2178 p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (dist[nx][ny] == 0 && a[nx][ny] == 1) {
                        q.add(new Pair_2178(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }
            }
        }
    }
}
