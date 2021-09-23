package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14500 {
    private static int[][] paper;
    private static boolean[][] visited;
    private static int n, m, ans = 0;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);
        paper = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(input2[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, 0, 0);
                exception(i, j);
            }
        }
        System.out.println(ans);
    }

    // ㅗ 모양을 제외한 테트로미노
    private static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            ans = Math.max(ans, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (visited[nx][ny]) continue;
            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, sum + paper[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    // ㅗ 모양 테트로미노 따로 처리
    // + 모양에서 하나를 빼는 방법
    private static void exception(int x, int y) {
        int wing = 4; // 상하좌우 날개
        int min = 1001;
        int sum = paper[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (wing < 3) return; // 날개가 3개 보다 작으면 ㅗ 모양이 나올 수 없음
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                wing--;
                continue;
            }
            min = Math.min(min, paper[nx][ny]);
            sum += paper[nx][ny];
        }
        if (wing == 4) sum -= min; // 날개가 4개면 가장 작은 날개를 없앰
        ans = Math.max(ans, sum);
    }
}
