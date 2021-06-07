package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_14891 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] wheel = new int[4][8];
        int[] top = new int[4];
        for (int i = 0; i < 4; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = Integer.parseInt(s[j]);
            }
        }
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]) - 1;
            int d = Integer.parseInt(s[1]);

            int originTop = top[n];
            if (d == 1) top[n] = (top[n] + 7) % 8;
            else top[n] = (top[n] + 1) % 8;

            int origin = originTop;
            int nd = d;
            for (int j = n; j > 0; j--) {
                if (wheel[j][(origin + 6) % 8] != wheel[j - 1][(top[j - 1] + 2) % 8]) {
                    origin = top[j - 1];
                    nd = -nd;
                    if (nd == 1) top[j - 1] = (top[j - 1] + 7) % 8;
                    else top[j - 1] = (top[j - 1] + 1) % 8;
                } else break;
            }

            origin = originTop;
            nd = d;
            for (int j = n; j < 3; j++) {
                if (wheel[j][(origin + 2) % 8] != wheel[j + 1][(top[j + 1] + 6) % 8]) {
                    origin = top[j + 1];
                    nd = -nd;
                    if (nd == 1) top[j + 1] = (top[j + 1] + 7) % 8;
                    else top[j + 1] = (top[j + 1] + 1) % 8;
                } else break;
            }
        }

        int ans = 0;
        int score = 1;
        for (int i = 0; i < 4; i++) {
            if (wheel[i][top[i]] == 1) ans += score;
            score *= 2;
        }
        System.out.println(ans);
    }
}
