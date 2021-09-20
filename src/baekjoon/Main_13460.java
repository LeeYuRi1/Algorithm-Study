package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Ball {
    int rx;
    int ry;
    int bx;
    int by;
    int count;

    public Ball(int rx, int ry, int bx, int by, int count) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.count = count;
    }
}

public class Main_13460 {
    private static String[][] board;
    private static boolean[][][][] check;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        board = new String[n][m];
        check = new boolean[n][m][n][m];
        Ball ball = new Ball(0, 0, 0, 0, 0);
        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = input2[j];
                if (board[i][j].equals("R")) {
                    ball.rx = i;
                    ball.ry = j;
                }
                if (board[i][j].equals("B")) {
                    ball.bx = i;
                    ball.by = j;
                }
            }
        }
        System.out.println(bfs(ball));
    }

    private static int bfs(Ball start) {
        Queue<Ball> queue = new LinkedList<>();
        queue.offer(start);
        check[start.rx][start.ry][start.bx][start.by] = true;
        while (!queue.isEmpty()) {
            Ball p = queue.poll();
            if (p.count > 10) return -1;
            if (board[p.bx][p.by].equals("O")) continue; // 파란색 빠져나가는 경우
            if (board[p.rx][p.ry].equals("O")) return p.count; // 빨간색이 빠져나가고 파란색은 빠져나가지 않는 경우
            for (int i = 0; i < 4; i++) {
                Ball b = move(p, i);
                if (check[b.rx][b.ry][b.bx][b.by]) continue;
                check[b.rx][b.ry][b.bx][b.by] = true;
                queue.offer(b);
            }
        }
        return -1;
    }

    private static Ball move(Ball ball, int i) {
        // 파란구슬 굴림
        int bnx = ball.bx;
        int bny = ball.by;
        while (!board[bnx + dx[i]][bny + dy[i]].equals("#")) { // 벽을 만나지 않을 때까지 감
            bnx += dx[i];
            bny += dy[i];
            if (board[bnx][bny].equals("O")) break;
        }
        //빨간구슬 굴림
        int rnx = ball.rx;
        int rny = ball.ry;
        while (!board[rnx + dx[i]][rny + dy[i]].equals("#")) {
            rnx += dx[i];
            rny += dy[i];
            if (board[rnx][rny].equals("O")) break;
        }
        // 두개 위치 동일하고 그 위치가 빠져나가는 곳이 아닌 경우
        if (rnx == bnx && rny == bny && !board[rnx][rny].equals("O")) {
            // 이동한 거리가 더 길면 한 칸 뒤로
            int rd = Math.abs(ball.rx - rnx) + Math.abs(ball.ry - rny);
            int bd = Math.abs(ball.bx - bnx) + Math.abs(ball.by - bny);
            if (rd > bd) {
                rnx -= dx[i];
                rny -= dy[i];
            } else {
                bnx -= dx[i];
                bny -= dy[i];
            }
        }
        return new Ball(rnx, rny, bnx, bny, ball.count + 1);
    }
}
