package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Point_3190 {
    int x;
    int y;

    Point_3190(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_3190 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] dummy = new int[n][n];
        for (int i = 0; i < k; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            dummy[x - 1][y - 1] = 1;
        }
        int l = Integer.parseInt(br.readLine());
        String[] dir = new String[10001];
        Arrays.fill(dir, "");
        for (int i = 0; i < l; i++) {
            String[] s = br.readLine().split(" ");
            dir[Integer.parseInt(s[0])] = s[1];
        }

        int time = 0;
        Queue<Point_3190> queue = new LinkedList<>();
        queue.add(new Point_3190(0, 0));
        int[] dx = {0, 1, 0, -1}; // 우 하 좌 상
        int[] dy = {1, 0, -1, 0};
        int nx = 0;
        int ny = 0;
        int d = 0;
        while (true) {
            if (dir[time].equals("L")) d = (d + 3) % 4;
            else if (dir[time].equals("D")) d = (d + 1) % 4;
            time++;
            nx += dx[d];
            ny += dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                queue.add(new Point_3190(nx, ny));
                if (dummy[nx][ny] == 2) break;
                if (dummy[nx][ny] == 1) {
                    dummy[nx][ny] = 0;
                } else {
                    Point_3190 p = queue.poll();
                    dummy[p.x][p.y] = 0;
                }
                dummy[nx][ny] = 2;
            } else break;
        }
        System.out.println(time);
    }
}
