package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3085 {

    private static String[][] board;
    private static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new String[n][n];
        int[] dx = {1, 0};
        int[] dy = {0, 1};

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = s[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < n && ny < n) {
                        swap(i, j, nx, ny);
                        check(n);
                        swap(i, j, nx, ny);
                    }
                }
            }
        }
        System.out.println(max);
    }

    private static void swap(int x, int y, int nx, int ny) {
        String temp = board[x][y];
        board[x][y] = board[nx][ny];
        board[nx][ny] = temp;
    }

    private static void check(int n) {
        String candyW = "";
        String candyH = "";
        for (int i = 0; i < n; i++) {
            int countW = 0;
            int countH = 0;
            for (int j = 0; j < n; j++) {
                if (candyW.equals(board[i][j])) countW++;
                else countW = 1;
                if (candyH.equals(board[j][i])) countH++;
                else countH = 1;
                candyW = board[i][j];
                candyH = board[j][i];
                max = Math.max(max, Math.max(countW, countH));
            }
        }
    }
}
