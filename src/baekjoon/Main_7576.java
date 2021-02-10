package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        a = new int[n][m];
        dist = new int[n][m];
        Queue q = new LinkedList();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                dist[i][j] = -1;
                if (a[i][j] == 1) {
                    q.add(new Pair_7576(i, j));
                    dist[i][j] = 0;
                }
            }
        }
        bfs(q, n, m);
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
        Pair_7576 p = q.remove();
        int x = p.x;
        int y = p.y;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < y) {
                if (a[nx][ny] == 0 && dist[nx][ny] == -1) {
                    q.add(new Pair_7576(nx, ny));
                    dist[nx][ny] = dist[x][y] + 1;
                }
            }
        }
    }
}
