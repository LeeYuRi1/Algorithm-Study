package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
    static private boolean[][] check;
    static private int[][] dist;
    static private int[] dx = {0, 0, 1, -1};
    static private int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        a = new int[n][m];
        check = new boolean[n][m];
        dist = new int[n][m];

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        bfs(n, m);
        System.out.println(dist[n-1][m-1]);
    }

    private static void bfs(int n, int m) {
        Queue<Pair_2178> q = new LinkedList();
        q.add(new Pair_2178(0, 0));
        check[0][0] = true;
        dist[0][0] = 1;
        while (!q.isEmpty()) {
            Pair_2178 p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (check[nx][ny] == false && a[nx][ny] == 1) {
                        q.add(new Pair_2178(nx, ny));
                        check[nx][ny] = true;
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }
            }
        }
    }
}
