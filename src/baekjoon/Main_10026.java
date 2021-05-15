package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10026 {
    static private int[] dx = {0, 0, 1, -1};
    static private int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] a1 = new String[n][n];
        String[][] a2 = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                if (input[j].equals("R") || input[j].equals("G")) a2[i][j] = "R";
                else a2[i][j] = input[j];
                a1[i][j] = input[j];
            }
        }
        System.out.println(findCount(a1, n) + " " + findCount(a2, n));
    }

    private static int findCount(String[][] a, int n) {
        boolean[][] check = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    dfs(a, check, i, j, n);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(String[][] a, boolean[][] check, int x, int y, int n) {
        check[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (a[nx][ny].equals(a[x][y]) && !check[nx][ny])
                    dfs(a, check, nx, ny, n);
            }
        }
    }
}
