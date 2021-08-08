package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 카카오프렌즈 컬러링북
public class Solution_1829 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] check = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j] || picture[i][j] == 0) continue;
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(m, n, i, j, picture[i][j], picture, check));
                numberOfArea++;
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static int bfs(int m, int n, int x, int y, int num, int[][] picture, boolean[][] check) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        check[x][y] = true;
        int result = 1;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (check[nx][ny] || picture[nx][ny] != num) continue;
                queue.offer(new int[]{nx, ny});
                check[nx][ny] = true;
                result++;
            }
        }
        return result;
    }
}
