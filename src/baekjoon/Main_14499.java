package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_14499 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        int x = Integer.parseInt(s1[2]);
        int y = Integer.parseInt(s1[3]);
        int k = Integer.parseInt(s1[4]);
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s2[j]);
            }
        }
        String[] s3 = br.readLine().split(" ");

        int[] dx = {0, 0, -1, 1}; // 동, 서, 북, 남
        int[] dy = {1, -1, 0, 0};
        int[] dice = new int[7];
        for (int i = 0; i < k; i++) {
            int d = Integer.parseInt(s3[i]);
            int nx = x + dx[d - 1];
            int ny = y + dy[d - 1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                move(d, dice);
                if (map[nx][ny] == 0) {
                    map[nx][ny] = dice[6];
                } else {
                    dice[6] = map[nx][ny];
                    map[nx][ny] = 0;
                }
                x = nx;
                y = ny;
                System.out.println(dice[1]);
            }
        }
    }

    private static void move(int d, int[] dice) {
        int temp = dice[1];
        switch (d) {
            case 1:
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = temp;
                break;
            case 2:
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
                break;
            case 3:
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;
                break;
            case 4:
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
                break;
        }
    }
}
