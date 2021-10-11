package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_16236 {
    private static int n, x, y, size = 2;
    private static int[][] area;
    private static int[][] dist;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int minX, minY, minD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        area = new int[n][n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(input[j]);
                if (area[i][j] == 9) {
                    x = i;
                    y = j;
                    area[i][j] = 0;
                }
            }
        }

        int time = 0;
        int eat = 0;
        while (true) {
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            for (int[] i : dist) Arrays.fill(i, -1);
            bfs();
            if (minX == Integer.MAX_VALUE) break; // 더 이상 먹을 수 있는 물고기가 공간에 없으면 끝냄
            x = minX; // 먹을 수 있고, 거리가 가장 가까운 물고기의 위치를 현재 위치로 함
            y = minY;
            eat++;
            if (eat == size) { // 상어의 크기만큼 물고기를 먹으면 크기 증가
                eat = 0;
                size++;
            }
            time += dist[x][y]; // 물고기를 먹으러 간 만큼의 시간동안 증가
            area[x][y] = 0;
        }
        System.out.println(time);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        dist[x][y] = 0;
        minD = Integer.MAX_VALUE; // 먹을 수 있는 물고기가 존재하는 최소거리
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (dist[nx][ny] != -1 || area[nx][ny] > size) continue; // 방문하지 않았고, 현재 크기보다 작거나 같으면 지나갈 수 있음
                dist[nx][ny] = dist[p[0]][p[1]] + 1;
                if (area[nx][ny] > 0 && area[nx][ny] < size) minDist(nx, ny); // 1이상이고 크기보다 작아야 먹을 수 있음
                queue.offer(new int[]{nx, ny});
            }
        }
    }

    private static void minDist(int nx, int ny) {
        if (dist[nx][ny] < minD) { // 가장 가까운 거리라면
            minD = dist[nx][ny];
            minX = nx;
            minY = ny;
        }
        if (dist[nx][ny] == minD) { // 가까운 거리의 물고기가 여러개면
            if (nx < minX) { // 가장 위에 있는 물고기
                minX = nx;
                minY = ny;
            } else if (nx == minX && ny < minY) { // 같은 높이라면 가장 왼쪽
                minX = nx;
                minY = ny;
            }
        }
    }
}
