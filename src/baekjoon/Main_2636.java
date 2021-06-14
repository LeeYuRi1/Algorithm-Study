package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point_2636 {
    int x;
    int y;

    Point_2636(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_2636 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        int[][] area = new int[n][m];
        int cheese = 0;
        for (int i = 0; i < n; i++) {
            String[] s2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                area[i][j] = Integer.parseInt(s2[j]);
                if (area[i][j] == 1) cheese++;
            }
        }
        int count = 0;
        int num = 0;
        while (cheese != 0) {
            num = cheese;
            cheese -= bfs(area, n, m);
            count++;
        }
        System.out.println(count);
        System.out.println(num);
    }

    private static int bfs(int[][] area, int n, int m) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int result = 0;
        Queue<Point_2636> queue = new LinkedList<>();
        boolean[][] check = new boolean[n][m];
        queue.offer(new Point_2636(0, 0));
        check[0][0] = true;
        while (!queue.isEmpty()) {
            Point_2636 p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!check[nx][ny]) {
                        if (area[nx][ny] == 1) {
                            area[nx][ny] = 0;
                            result++;
                        } else {
                            queue.offer(new Point_2636(nx, ny));
                        }
                        check[nx][ny] = true;
                    }
                }
            }
        }
        return result;
    }
}
