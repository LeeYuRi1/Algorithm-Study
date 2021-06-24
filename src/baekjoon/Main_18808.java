package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_18808 {
    private static int[][] notebook;
    private static int[][] sticker;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        int k = Integer.parseInt(s1[2]);
        notebook = new int[n][m];
        while (k-- > 0) {
            String[] s2 = br.readLine().split(" ");
            int r = Integer.parseInt(s2[0]);
            int c = Integer.parseInt(s2[1]);
            sticker = new int[r][c];
            for (int i = 0; i < r; i++) {
                String[] s3 = br.readLine().split(" ");
                for (int j = 0; j < c; j++) {
                    sticker[i][j] = Integer.parseInt(s3[j]);
                }
            }
            for (int i = 0; i < 4; i++) {
                if (find(n, m, r, c)) break;
                sticker = rotate(r, c);
                int temp = r;
                r = c;
                c = temp;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (notebook[i][j] == 1) ans++;
            }
        }
        System.out.println(ans);
    }

    private static int[][] rotate(int r, int c) {
        int[][] temp = new int[c][r];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                temp[i][j] = sticker[r - 1 - j][i];
            }
        }
        return temp;
    }

    private static boolean find(int n, int m, int r, int c) {
        for (int i = 0; i <= n - r; i++) {
            for (int j = 0; j <= m - c; j++) {
                boolean check = true;
                for (int k = 0; k < r; k++) {
                    for (int l = 0; l < c; l++) {
                        if (notebook[i + k][j + l] == 1 && sticker[k][l] == 1) check = false;
                    }
                }
                if (check) {
                    for (int k = 0; k < r; k++) {
                        for (int l = 0; l < c; l++) {
                            if (sticker[k][l] == 1) notebook[i + k][j + l] = 1;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
