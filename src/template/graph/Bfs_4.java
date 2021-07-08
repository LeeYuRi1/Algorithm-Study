package template.graph;

import java.util.LinkedList;
import java.util.Queue;

// 시작점이 여러개인 경우 (예제 설명: 백준 7576)
public class Bfs_4 {
    private static int[] dx = {-1, 1, 0, 0}; // 위, 아래, 왼쪽, 오른쪽
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        int[][] a = {{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1}};
//        int[][] a = {{0, -1, 0, 0, 0, 0}, {-1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1}};
        int n = 4;
        int m = 6;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[n][m];
        // 값이 1인 위치를 큐에 넣어줌(시작점들을 저장), dist를 -1로 초기화하고 값이 1이면 dist는 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = -1;
                if (a[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }
        bfs(queue, a, dist, n, m);

        // 모두 1이 될 때까지의 최소 날짜 구하기
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] > ans) ans = dist[i][j];
            }
        }
        // 모두 1이 되지 못하면 -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0 && dist[i][j] == -1) ans = -1;
            }
        }
        System.out.println(ans);
    }

    private static void bfs(Queue<int[]> queue, int[][] a, int[][] dist, int n, int m) {
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 | ny >= m) continue;
                if (dist[nx][ny] != -1 || a[nx][ny] != 0) continue;
                queue.offer(new int[]{nx, ny});
                dist[nx][ny] = dist[p[0]][p[1]] + 1;
            }
        }
    }
}
