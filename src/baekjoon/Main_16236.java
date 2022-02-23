package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//소요 시간 : 88 ms
//메모리 사용량 : 12560 kb
public class Main_16236 {
    private static int N, x, y, size, min;
    private static int area[][], dist[][];
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (area[i][j] == 9) {
                    x = i;
                    y = j;
                    area[i][j] = 0;
                }
            }
        }
        size = 2;
        int eat = 0, time = 0;
        while (true) {
            dist = new int[N][N];
            min = Integer.MAX_VALUE;
            bfs();
            if (min == Integer.MAX_VALUE) break; // 최소거리가 업데이트 되지 않았다면 먹을 수 있는 물고기가 없음
            time += dist[x][y] - 1;
            area[x][y] = 0;
            eat++;
            if (eat == size) {
                eat = 0;
                size++;
            }
        }
        System.out.println(time);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        dist[x][y] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (dist[cur[0]][cur[1]] > min) return; // 현재 dist가 최소거리보다 크다면 이제 고려할 일 없음
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (area[nx][ny] > size || dist[nx][ny] > 0) continue; // 아기상어 크기보다 크거나, 이미 지나간 길이면 지나갈 수 없음
                queue.offer(new int[]{nx, ny});
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                if (findMinDist(dist[nx][ny], nx, ny)) { // 가장 가까운 물고기 찾기
                    min = dist[nx][ny]; // 제일 가까운 거리로 업데이트
                    x = nx;
                    y = ny;
                }
            }
        }
    }

    private static boolean findMinDist(int d, int nx, int ny) {
        if (area[nx][ny] == 0 || area[nx][ny] == size) return false; // 0이거나 아기상어의 사이즈와 같다면 먹을 수 없음
        if (d < min) return true;
        if (d == min && ((nx < x) || (nx == x && ny < y))) return true;
        return false;
    }
}
