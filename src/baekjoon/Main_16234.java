package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point_16234 {
    int x;
    int y;

    Point_16234(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_16234 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int l = Integer.parseInt(s1[1]);
        int r = Integer.parseInt(s1[2]);

        int[][] country = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s2 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                country[i][j] = Integer.parseInt(s2[j]);
            }
        }

        // 인구 이동이 없을 때까지 반복
        int ans = 0;
        while (true) {
            boolean[][] check = new boolean[n][n];
            boolean stop = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!check[i][j]) {
                        boolean ok = bfs(country, check, i, j, n, l, r);
                        if (ok) stop = false; // 인구이동이 한번이라도 있으면 체크
                    }
                }
            }
            if (!stop) ans++;
            else break;
        }
        System.out.println(ans);
    }

    private static boolean bfs(int[][] country, boolean[][] check, int x, int y, int n, int l, int r) {
        Queue<Point_16234> queue = new LinkedList<>();
        Queue<Point_16234> sumQueue = new LinkedList<>(); //연합된 나라들
        int sum = 0;
        queue.add(new Point_16234(x, y));
        check[x][y] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            Point_16234 p = queue.poll();
            sumQueue.add(p);
            sum += country[p.x][p.y];
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int dif = Math.abs(country[p.x][p.y] - country[nx][ny]);
                    if (!check[nx][ny] && dif >= l && dif <= r) {
                        queue.add(new Point_16234(nx, ny));
                        check[nx][ny] = true;
                    }
                }
            }
        }
        // 연합된 나라의 개수가 1이라면 인구이동이 없고, 1 이상이면 연합의 인구수/개수로 바꾸어줌
        if (sumQueue.size() == 1) return false;
        int add = sum / sumQueue.size();
        while (!sumQueue.isEmpty()) {
            Point_16234 p = sumQueue.poll();
            country[p.x][p.y] = add;
        }
        return true;
    }
}
