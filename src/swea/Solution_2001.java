package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소요 시간 : 102 ms
// 메모리 사용량 : 19,132 kb
public class Solution_2001 {
    private static int[][] area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= t; testCase++) {
            String[] input1 = br.readLine().split(" ");
            int n = Integer.parseInt(input1[0]);
            int m = Integer.parseInt(input1[1]);
            area = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] input2 = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    area[i][j] = Integer.parseInt(input2[j]);
                }
            }
            int count = 0;
            for (int i = 0; i <= n - m; i++) {
                for (int j = 0; j <= n - m; j++) {
                    count = Math.max(count, checkNum(i, j, m));
                }
            }
            sb.append("#" + testCase + " " + count + "\n");
        }
        System.out.println(sb);
    }

    private static int checkNum(int x, int y, int m) {
        int count = 0;
        for (int i = x; i < x + m; i++) {
            for (int j = y; j < y + m; j++) {
                count += area[i][j];
            }
        }
        return count;
    }
}
