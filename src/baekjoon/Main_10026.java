package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소요 시간 : 92 ms
// 메모리 사용량 : 12320 kb
public class Main_10026 {
    private static int N, count;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] area = new char[N][];
        char[][] area2 = new char[N][N];
        for (int i = 0; i < N; i++) {
            area[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                area2[i][j] = (area[i][j] == 'R') ? 'G' : area[i][j];
            }
        }
        System.out.println(getNumArea(area) + " " + getNumArea(area2));
    }

    private static int getNumArea(char[][] area) {
        visited = new boolean[N][N];
        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                dfs(i, j, area);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int x, int y, char[][] area) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (visited[nx][ny] || area[x][y] != area[nx][ny]) continue;
            dfs(nx, ny, area);
        }
    }
}