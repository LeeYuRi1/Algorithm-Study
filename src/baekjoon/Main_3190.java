package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_3190 {
    private static int[][] board;
    private static int n, d = 0;
    private static int[] dx = {0, 1, 0, -1}; //우하좌상
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        board = new int[n][n];
        while (k-- > 0) {
            String[] input = br.readLine().split(" ");
            board[Integer.parseInt(input[0]) - 1][Integer.parseInt(input[1]) - 1] = 1;
        }
        int l = Integer.parseInt(br.readLine());
        char[] dir = new char[10001];
        while (l-- > 0) {
            String[] input = br.readLine().split(" ");
            dir[Integer.parseInt(input[0])] = input[1].charAt(0);
        }
        System.out.println(move(dir));
    }

    private static int move(char[] dir) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        board[0][0] = 2;
        int nx = 0;
        int ny = 0;
        int count = 0;
        while (true) {
            if (dir[count] == 'L') d = (d + 3) % 4;
            if (dir[count] == 'D') d = (d + 1) % 4;
            count++;

            nx += dx[d];
            ny += dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) return count; // 벽과 부딪힘
            if (board[nx][ny] == 2) return count; // 자기몸과 부딪힘
            if (board[nx][ny] == 1) { //사과 있으면
                board[nx][ny] = 0;
            } else { //사과 없으면
                int[] p = queue.poll();
                board[p[0]][p[1]] = 0;
            }
            queue.offer(new int[]{nx, ny});
            board[nx][ny] = 2;
        }
    }
}
