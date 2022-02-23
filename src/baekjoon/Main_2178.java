package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// dfs로 문제를 풀 수 없음. bfs 사용 (단계별로 진행)
// 모든 가중치가 1이면 최단거리 알고리즘을 bfs로 구할 수 있음
public class Main_2178 {
    private static int N, M;
    private static char[][] area;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        area = new char[N][];
        for (int i = 0; i < N; i++) {
            area[i] = br.readLine().toCharArray();
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[N][M];
        queue.offer(new int[]{0, 0});
        dist[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == N - 1 && cur[1] == M - 1) return dist[N - 1][M - 1];
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (dist[nx][ny] > 0 || area[nx][ny] == '0') continue;
                queue.offer(new int[]{nx, ny});
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
            }
        }
        return 0;
    }
}