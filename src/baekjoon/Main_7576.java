package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 소요 시간 : 604 ms
// 메모리 사용량 : 124344 kb
public class Main_7576 {
    private static int N, M, area[][], dist[][];
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        area = new int[N][M];
        dist = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (area[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    dist[i][j] = 1;
                }
                if (area[i][j] != 0) count++;
            }
        }
        System.out.println((count == N * M) ? 0 : bfs(queue));
    }

    private static int bfs(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (dist[nx][ny] > 0 || area[nx][ny] != 0) continue;
                queue.offer(new int[]{nx, ny});
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
            }
        }
        return getMaxDist();
    }

    private static int getMaxDist() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] == 0 && dist[i][j] == 0) return -1;
                max = Math.max(max, dist[i][j]);
            }
        }
        return max - 1;
    }
}
