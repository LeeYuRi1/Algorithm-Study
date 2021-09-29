package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Pair_1261 implements Comparable<Pair_1261> {
    int x;
    int y;
    int wall;

    public Pair_1261(int x, int y, int wall) {
        this.x = x;
        this.y = y;
        this.wall = wall;
    }

    @Override
    public int compareTo(Pair_1261 o) {
        return this.wall - o.wall;
    }
}

public class Main_1261 {
    private static int n, m;
    private static int[][] maze;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        m = Integer.parseInt(input1[0]);
        n = Integer.parseInt(input1[1]);
        maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(input2[j]);
            }
        }
        System.out.println(numOfBrokenWall());
    }

    private static int numOfBrokenWall() {
        PriorityQueue<Pair_1261> pq = new PriorityQueue<>();
        pq.offer(new Pair_1261(0, 0, 0));
        boolean[][] check = new boolean[n][m];
        check[0][0] = true;
        while (!pq.isEmpty()) {
            Pair_1261 p = pq.poll();
            if (p.x == n - 1 && p.y == m - 1) return p.wall;
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || check[nx][ny]) continue;
                check[nx][ny] = true;
                if (maze[nx][ny] == 0) pq.offer(new Pair_1261(nx, ny, p.wall));
                else pq.offer(new Pair_1261(nx, ny, p.wall + 1));
            }
        }
        return 0;
    }
}
