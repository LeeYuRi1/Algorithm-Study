package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair_17142 {
    int x;
    int y;
    int time;

    public Pair_17142(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main_17142 {
    private static int n, m, ans = Integer.MAX_VALUE, countZero = 0;
    private static int[][] area;
    private static Pair_17142[] active;
    private static List<Pair_17142> virus = new ArrayList<>();
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);
        area = new int[n][n];
        active = new Pair_17142[m];
        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(input2[j]);
                if (area[i][j] == 0) countZero++;
                if (area[i][j] == 2) virus.add(new Pair_17142(i, j, 0));
            }
        }
        dfs(0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static void dfs(int depth, int start) {
        if (depth == m) {
            bfs();
            return;
        }
        for (int i = start; i < virus.size(); i++) {
            active[depth] = virus.get(i);
            dfs(depth + 1, i + 1);
        }
    }

    private static void bfs() {
        Queue<Pair_17142> queue = new LinkedList<>();
        boolean[][] check = new boolean[n][n];
        for (Pair_17142 i : active) {
            queue.offer(i);
            check[i.x][i.y] = true;
        }

        int count = 0;
        int time = 0;
        while (!queue.isEmpty()) {
            Pair_17142 p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (area[nx][ny] == 1 || check[nx][ny]) continue;
                if (area[nx][ny] == 0) {
                    count++;
                    time = p.time + 1;
                }
                queue.offer(new Pair_17142(nx, ny, p.time + 1));
                check[nx][ny] = true;
            }
        }
        if (count == countZero) ans = Math.min(ans, time);
    }
}
