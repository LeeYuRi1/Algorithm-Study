package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Fish {
    int x;
    int y;

    public Fish(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_16236 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] d;
    private static int[][] area;
    private static int size = 2;
    private static int minX, minY, minD;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        area = new int[n][n];
        d = new int[n][n];
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(s[j]);
                if (area[i][j] == 9) {
                    x = i;
                    y = j;
                    area[i][j] = 0;
                }
            }
        }

        int ans = 0;
        int eat = 0;
        while (true) {
            minD = Integer.MAX_VALUE;
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            for (int[] i : d) Arrays.fill(i, -1);
            bfs(x, y, n);
            if (minX == Integer.MAX_VALUE) break;
            ans += d[minX][minY];
            eat++;
            if (size == eat) {
                size++;
                eat = 0;
            }
            area[minX][minY] = 0;
            x = minX;
            y = minY;
        }
        System.out.println(ans);
    }

    // 가장 가까운 물고기 찾기
    private static void bfs(int x, int y, int n) {
        Queue<Fish> queue = new LinkedList<>();
        queue.add(new Fish(x, y));
        d[x][y] = 0;
        while (!queue.isEmpty()) {
            Fish f = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = f.x + dx[i];
                int ny = f.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (d[nx][ny] == -1 && area[nx][ny] <= size) {
                        d[nx][ny] = d[f.x][f.y] + 1;
                        if (area[nx][ny] > 0 && area[nx][ny] < size) {
                            if (d[nx][ny] < minD) {
                                minD = d[nx][ny];
                                minX = nx;
                                minY = ny;
                            } else if (d[nx][ny] == minD) {
                                if (nx == minX && ny < minY) { //위쪽
                                    minX = nx;
                                    minY = ny;
                                } else if (nx < minX) { //왼쪽
                                    minX = nx;
                                    minY = ny;
                                }
                            }
                        }
                        queue.add(new Fish(nx, ny));
                    }
                }
            }
        }
    }
}
