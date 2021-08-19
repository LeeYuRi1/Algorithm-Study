package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2583 {
    private static int[][] a;
    private static int n, m;
    private static boolean[][] check;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);
        int k = Integer.parseInt(input1[2]);

        a = new int[n][m];
        check = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            String[] input2 = br.readLine().split(" ");
            draw(Integer.parseInt(input2[0]), Integer.parseInt(input2[1]), Integer.parseInt(input2[2]), Integer.parseInt(input2[3]));
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1 || check[i][j]) continue;
                ans.add(bfs(i, j));
            }
        }
        Collections.sort(ans);
        System.out.println(ans.size());
        for (int i : ans) System.out.print(i + " ");
    }

    private static void draw(int startX, int startY, int endX, int endY) {
        for (int i = startY; i < endY; i++) {
            for (int j = startX; j < endX; j++) {
                a[i][j] = 1;
            }
        }
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        check[x][y] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (check[nx][ny] || a[nx][ny] == 1) continue;
                queue.offer(new int[]{nx, ny});
                check[nx][ny] = true;
                count++;
            }
        }
        return count;
    }
}
