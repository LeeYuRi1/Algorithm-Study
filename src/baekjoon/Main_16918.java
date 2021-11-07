package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_16918 {
    private static int[][] area;
    private static int r, c;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        r = Integer.parseInt(input1[0]);
        c = Integer.parseInt(input1[1]);
        int n = Integer.parseInt(input1[2]);
        area = new int[r][c];
        for (int i = 0; i < r; i++) {
            String[] input2 = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                if (input2[j].equals("O")) area[i][j] = 3; // 폭탄
                else area[i][j] = 0; // 빈칸
            }
        }

        int t = 1;
        while (t < n) {
            step1(++t);
            if (t == n) break;
            step2(++t);
        }
        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (area[i][j] == 0) sb.append(".");
                else sb.append("O");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void step1(int t) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (area[i][j] == 0) area[i][j] = t + 3;
            }
        }
    }

    private static void step2(int t) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (area[i][j] == t) queue.offer(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            area[p[0]][p[1]] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                area[nx][ny] = 0;
            }
        }
    }
}
