package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1780 {

    private static int[][] num;
    private static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        num = new int[n][n];
        count = new int[3];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                num[i][j] = Integer.parseInt(s[j]);
            }
        }
        find(0, 0, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(count[i] + "\n");
        }
        System.out.println(sb);
    }

    private static void find(int x, int y, int n) {
        if (check(x, y, n)) {
            count[num[x][y] + 1]++;
        } else {
            int l = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    find(x + i * l, y + j * l, l);
                }
            }
        }
    }

    private static boolean check(int x, int y, int n) {
        int t = num[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (num[i][j] != t) return false;
            }
        }
        return true;
    }
}
