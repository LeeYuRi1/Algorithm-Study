package baekjoon;

import java.util.Scanner;

public class Main_4963 {

    static private int[][] a;
    static private int[][] d;
    static private int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static private int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            if (w == 0 && h == 0) break;

            a = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            int cnt = 0;
            d = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (a[i][j] == 1 && d[i][j] == 0) // 정점이고 아직 방문하지 않으면 dfs 호출
                        dfs(i, j, ++cnt, w, h);
                }
            }
            System.out.println(cnt);
        }
    }

    private static void dfs(int x, int y, int cnt, int w, int h) {
        d[x][y] = cnt;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                if (a[nx][ny] == 1 && d[nx][ny] == 0)
                    dfs(nx, ny, cnt, w, h);
            }
        }
    }
}
