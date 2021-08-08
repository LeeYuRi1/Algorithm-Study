package programmers;

import java.util.LinkedList;
import java.util.Queue;

// 게임 맵 최단거리
class Point_1844 {
    int x;
    int y;
    int dist;

    public Point_1844(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    public Point_1844 moved(int dx, int dy) {
        return new Point_1844(this.x + dx, this.y + dy, this.dist + 1);
    }
}

public class Solution_1844 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
    }

    public static int solution(int[][] maps) {
        return getShortestDistance(maps, maps.length, maps[0].length);
    }

    private static int getShortestDistance(int[][] maps, int n, int m) {
        Queue<Point_1844> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new Point_1844(0, 0, 1));
        while (!queue.isEmpty()) {
            Point_1844 p = queue.poll();
            if (p.x == n - 1 && p.y == m - 1) return p.dist;
            for (int i = 0; i < 4; i++) {
                Point_1844 np = p.moved(dx[i], dy[i]);
                if (np.x < 0 || np.x >= n || np.y < 0 || np.y >= m) continue;
                if (visited[np.x][np.y] || maps[np.x][np.y] == 0) continue;
                queue.offer(np);
                visited[np.x][np.y] = true;
            }
        }
        return -1;
    }
}
