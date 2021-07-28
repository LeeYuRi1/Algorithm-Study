package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_7562 {
    private static int[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int l = Integer.parseInt(br.readLine());
            String[] s1 = br.readLine().split(" ");
            String[] s2 = br.readLine().split(" ");
            dist = new int[l][l];
            for (int[] i : dist) Arrays.fill(i, -1);
            sb.append(bfs(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]), Integer.parseInt(s2[0]), Integer.parseInt(s2[1]), l) + "\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int startX, int startY, int endX, int endY, int l) {
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        dist[startX][startY] = 0;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            if (p[0] == endX && p[1] == endY) return dist[endX][endY];
            for (int i = 0; i < 8; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 0 || nx >= l || ny < 0 || ny >= l) continue;
                if (dist[nx][ny] != -1) continue;
                queue.offer(new int[]{nx, ny});
                dist[nx][ny] = dist[p[0]][p[1]] + 1;
            }
        }
        return -1;
    }
}
