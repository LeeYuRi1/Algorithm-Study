package template.graph;

import java.util.LinkedList;
import java.util.Queue;

// 플러드필(예제 설명: 백준 1926)
public class Bfs_2 {
    private static int[] dx = {-1, 1, 0, 0}; // 위, 아래, 왼쪽, 오른쪽
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        int[][] a = {{1, 1, 0, 1, 1}, {0, 1, 1, 0, 0}, {0, 0, 0, 0, 0}, {1, 0, 1, 1, 1}, {0, 0, 1, 1, 1}, {0, 0, 1, 1, 1}};
        int n = 6;
        int m = 5;
        boolean[][] check = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j] && a[i][j] == 1) {
                    bfs(a, check, i, j, n, m);
                    count++;
                }
            }
        }
        System.out.println(count); // 1의 영역 개수 구하기
    }

    private static void bfs(int[][] a, boolean[][] check, int x, int y, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        check[x][y] = true;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 배열 밖으로 나가면 넘어가기
                if (check[nx][ny] || a[nx][ny] == 0) continue; // 이미 방문했거나 값이 0이면 넘어가기
                queue.add(new int[]{nx, ny});
                check[nx][ny] = true;
            }
        }
    }
}
