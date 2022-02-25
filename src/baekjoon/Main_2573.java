package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Point_2573 {
    int x;
    int y;

    public Point_2573(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_2573 {
    private static int N, M, area[][];
    private static List<Point_2573> points;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        area = new int[N][M];
        points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (area[i][j] > 0) points.add(new Point_2573(i, j));
            }
        }
        int num, ans = 0;
        while ((num = check()) == 1) {
            decrease();
            ans++;
        }
        System.out.println(num == 0 ? 0 : ans);
    }

    private static void decrease() {
        int[][] temp = new int[N][M];
        for (int i = 0; i < points.size(); i++) {
            Point_2573 cur = points.get(i);
            int x = cur.x, y = cur.y, count = 0;
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || area[nx][ny] > 0) continue;
                count++;
            }
            temp[x][y] = area[x][y] - count;
            if (temp[x][y] <= 0) {
                temp[x][y] = 0;
                points.remove(i--);
            }
        }
        area = temp;
    }

    private static int check() {
        boolean[][] visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] || area[i][j] == 0) continue;
                dfs(visited, i, j);
                count++;
            }
        }
        return count;
    }

    private static void dfs(boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (!visited[nx][ny] && area[nx][ny] != 0) dfs(visited, nx, ny);
        }
    }
}
