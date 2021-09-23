package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14499 {
    private static int[] dice = new int[7];
    private static int[][] map;
    private static int x, y;
    private static int[] dx = {0, 0, -1, 1}; //우좌상하
    private static int[] dy = {1, -1, 0, 0};
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        x = Integer.parseInt(input1[2]);
        y = Integer.parseInt(input1[3]);
        int k = Integer.parseInt(input1[4]);
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input2[j]);
            }
        }
        String[] input3 = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            int d = Integer.parseInt(input3[i]) - 1;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            x = nx;
            y = ny;
            move(d + 1);
        }
        System.out.println(sb);
    }

    private static void move(int d) {
        switch (d) {
            case 1: // 오른쪽
                rollDice(1, 4, 6, 3);
                copy();
                break;
            case 2: // 왼쪽
                rollDice(1, 3, 6, 4);
                copy();
                break;
            case 3: // 위쪽
                rollDice(1, 5, 6, 2);
                copy();
                break;
            case 4: //아래쪽
                rollDice(1, 2, 6, 5);
                copy();
                break;
        }
        sb.append(dice[1] + "\n");
    }

    private static void rollDice(int n1, int n2, int n3, int n4) {
        int temp = dice[n1];
        dice[n1] = dice[n2];
        dice[n2] = dice[n3];
        dice[n3] = dice[n4];
        dice[n4] = temp;
    }

    private static void copy() {
        if (map[x][y] == 0) {
            map[x][y] = dice[6];
        } else {
            dice[6] = map[x][y];
            map[x][y] = 0;
        }
    }
}