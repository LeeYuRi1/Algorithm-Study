package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17822 {
    private static int n, m;
    private static int[][] circle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);
        int t = Integer.parseInt(input1[2]);
        circle = new int[n + 1][m];
        for (int i = 1; i <= n; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                circle[i][j] = Integer.parseInt(input2[j]);
            }
        }
        for (int i = 0; i < t; i++) {
            String[] input3 = br.readLine().split(" ");
            int x = Integer.parseInt(input3[0]);
            int d = Integer.parseInt(input3[1]);
            int k = Integer.parseInt(input3[2]);
            rotation(x, d, k);
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                ans += circle[i][j];
            }
        }
        System.out.println(ans);
    }

    private static void rotation(int x, int d, int k) {
        // 번호가 x의 배수인 원판을 d 방향으로 k칸 회전
        int[] temp = new int[m];
        int curX = x;
        while (curX <= n) {
            if (d == 0) { // 0: 시계방향
                for (int i = 0; i < m; i++) {
                    int j = (i + k) % m;
                    temp[j] = circle[curX][i];
                }
                for (int i = 0; i < m; i++) {
                    circle[curX][i] = temp[i];
                }
            } else { // 1: 반시계방향
                for (int i = 0; i < m; i++) {
                    int j = (i + k * (m - 1)) % m;
                    temp[j] = circle[curX][i];
                }
                for (int i = 0; i < m; i++) {
                    circle[curX][i] = temp[i];
                }
            }
            curX += x;
        }

        // 원판에 수가 남아있으면 인접하면서 수가 같은것 찾음
        boolean[][] over = new boolean[n + 1][m];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (circle[i][j] == circle[i][j + 1] && circle[i][j] != 0) {
                    over[i][j] = over[i][j + 1] = true;
                }
            }
            if (circle[i][0] == circle[i][m - 1] && circle[i][0] != 0) {
                over[i][0] = over[i][m - 1] = true;
            }
        }
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                if (circle[i][j] == circle[i + 1][j] && circle[i][j] != 0) {
                    over[i][j] = over[i + 1][j] = true;
                }
            }
        }

        boolean check = false;
        int sum = 0;
        int num = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (over[i][j]) {
                    check = true;
                    circle[i][j] = 0;
                }
                if (circle[i][j] != 0) {
                    sum += circle[i][j];
                    num++;
                }
            }
        }
        if (!check) {
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < m; j++) {
                    if (circle[i][j] == 0) continue;
                    if (circle[i][j] * num > sum) circle[i][j]--;
                    else if (circle[i][j] * num < sum) circle[i][j]++;
                }
            }
        }
    }
}
