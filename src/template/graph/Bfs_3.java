package template.graph;

import java.util.LinkedList;
import java.util.Queue;

// 최단거리 구하기(예제 설명: 백준 2178)
public class Bfs_3 {
    private static int[] dx = {-1, 1, 0, 0}; // 위, 아래, 왼쪽, 오른쪽
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        int[][] a = {{1, 0, 1, 1, 1, 1}, {1, 0, 1, 0, 1, 0}, {1, 0, 1, 0, 1, 1}, {1, 1, 1, 0, 1, 1}};
        int n = 4;
        int m = 6;
        int[][] dist = new int[n][m];
        bfs(a, dist, n, m);
        //(0,0)에서 (n-1, m-1)로 이동할 때 지나야 하는 최소의 칸 수 (시작, 도착 위치 포함)
        System.out.println(dist[n - 1][m - 1]);
    }

    private static void bfs(int[][] a, int[][] dist, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        dist[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 | ny >= m) continue; // 배열 밖으로 나가면 넘어가기
                if (dist[nx][ny] != 0 || a[nx][ny] == 0) continue; // 이미 방문했거나 값이 0이면 넘어가기(dist가 0이면 방문하지 않은 것)
                queue.offer(new int[]{nx, ny});
                dist[nx][ny] = dist[p[0]][p[1]] + 1;
            }
        }
    }
}
