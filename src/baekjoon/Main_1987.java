package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987 {
    private static int r, c, ans = 0;
    private static char[][] board;
    private static boolean visited[];
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][];
        visited = new boolean[26];
        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
        }
        dfs(0, 0, 1);
        System.out.println(ans);
    }

    private static void dfs(int x, int y, int count) {
        visited[board[x][y] - 'A'] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c || visited[board[nx][ny] - 'A']) continue;
            dfs(nx, ny, count + 1);
        }
        ans = Math.max(ans, count);
        visited[board[x][y] - 'A'] = false;
    }
}
