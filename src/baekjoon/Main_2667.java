package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_2667 {
    private static int N, count;
    private static char[][] area;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new char[N][];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            area[i] = br.readLine().toCharArray();
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] || area[i][j] == '0') continue;
                count = 0;
                dfs(i, j);
                ans.add(count);
            }
        }
        Collections.sort(ans);
        System.out.println(ans.size());
        for (int i : ans) System.out.println(i);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (visited[nx][ny] || area[nx][ny] == '0') continue;
            dfs(nx, ny);
        }
    }
}