package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14891 {
    private static int[][] wheel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheel = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String[] input1 = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = Integer.parseInt(input1[j]);
            }
        }

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            String[] input2 = br.readLine().split(" ");
            int n = Integer.parseInt(input2[0]) - 1;
            int[] dir = new int[4];
            dir[n] = Integer.parseInt(input2[1]);
            for (int i = n; i < 3; i++) {
                if (wheel[i][2] == wheel[i + 1][6]) break;
                dir[i + 1] = dir[i] * -1;
            }
            for (int i = n; i >= 1; i--) {
                if (wheel[i][6] == wheel[i - 1][2]) break;
                dir[i - 1] = dir[i] * -1;
            }
            move(dir);
        }

        int ans = 0;
        for (int i = 0; i < 4; i++) {
            ans += wheel[i][0] * Math.pow(2, i);
        }
        System.out.println(ans);
    }

    private static void move(int[] dir) {
        for (int i = 0; i < dir.length; i++) {
            if (dir[i] == 1) { // 시계 방향
                int temp = wheel[i][7];
                for (int j = 7; j >= 1; j--) {
                    wheel[i][j] = wheel[i][j - 1];
                }
                wheel[i][0] = temp;
            } else if (dir[i] == -1) { // 반시계 방향
                int temp = wheel[i][0];
                for (int j = 0; j < 7; j++) {
                    wheel[i][j] = wheel[i][j + 1];
                }
                wheel[i][7] = temp;
            }
        }
    }
}
