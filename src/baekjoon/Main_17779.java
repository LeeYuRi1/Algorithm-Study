package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_17779 {
    private static int n;
    private static int[][] area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int sum = 0;
        area = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(input[j]);
                sum += area[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int d1 = 1; d1 < n; d1++) {
                    for (int d2 = 1; d2 < n; d2++) {
                        if (x + d1 + d2 < n && y - d1 >= 1 && y + d2 < n) {
                            ans = Math.min(ans, getPopulationNum(x, y, d1, d2, sum));
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static int getPopulationNum(int x, int y, int d1, int d2, int sum) {
        boolean[][] border = new boolean[n][n];
        // 1, 4번 경계선
        for (int i = 0; i <= d1; i++) {
            border[x + i][y - i] = true;
            border[x + d2 + i][y + d2 - i] = true;
        }
        // 2, 3번 경계선
        for (int i = 0; i <= d2; i++) {
            border[x + i][y + i] = true;
            border[x + d1 + i][y - d1 + i] = true;
        }

        int[] num = new int[5];
        // 1번 선거구
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (border[i][j]) break;
                num[0] += area[i][j];
            }
        }
        // 2번 선거구
        for (int i = 0; i <= x + d2; i++) {
            for (int j = n - 1; j > y; j--) {
                if (border[i][j]) break;
                num[1] += area[i][j];
            }
        }
        // 3번 선거구
        for (int i = x + d1; i < n; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (border[i][j]) break;
                num[2] += area[i][j];
            }
        }
        // 4번 선거구
        for (int i = x + d2 + 1; i < n; i++) {
            for (int j = n - 1; j >= y - d1 + d2; j--) {
                if (border[i][j]) break;
                num[3] += area[i][j];
            }
        }
        // 5번 선거구
        for (int i = 0; i < 4; i++) {
            sum -= num[i];
        }
        num[4] = sum;
        Arrays.sort(num);
        return num[4] - num[0];
    }
}
