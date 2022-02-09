package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소요 시간 : 148 ms
// 메모리 사용량 : 29,928 kb
public class Solution_2805 {
    private static int n;
    private static int[][] area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            area = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split("");
                for (int j = 0; j < n; j++) {
                    area[i][j] = Integer.parseInt(input[j]);
                }
            }
            sb.append("#").append(tc).append(" ").append(getProfit()).append("\n");
        }
        System.out.println(sb);
    }

    private static int getProfit() {
        int start = n / 2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = start; j < n - start; j++) {
                sum += area[i][j];
            }
            start = i < n / 2 ? start - 1 : start + 1;
        }
        return sum;
    }
}
