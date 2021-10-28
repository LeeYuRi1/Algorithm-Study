package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                triangle[i - 1][j] = Math.max(triangle[i][j], triangle[i][j + 1]) + triangle[i - 1][j];
            }
        }
        System.out.println(triangle[0][0]);
    }
}
