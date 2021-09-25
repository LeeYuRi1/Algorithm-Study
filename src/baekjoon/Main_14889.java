package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14889 {
    private static int[][] ability;
    private static int[] arr;
    private static int n, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ability = new int[n][n];
        arr = new int[n / 2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                ability[i][j] = Integer.parseInt(input[j]);
            }
        }
        selectTeam(0, 0);
        System.out.println(ans);
    }

    private static void selectTeam(int depth, int start) {
        if (depth == n / 2) {
            calculation();
            return;
        }
        for (int i = start; i < n; i++) {
            arr[depth] = i;
            selectTeam(depth + 1, i + 1);
        }
    }

    private static void calculation() {
        int[] team = new int[n];
        for (int i : arr) team[i] = 1;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = team[i] + team[j];
                if (t == 0) sum1 += ability[i][j] + ability[j][i];
                if (t == 2) sum2 += ability[i][j] + ability[j][i];
            }
        }
        ans = Math.min(ans, Math.abs(sum1 - sum2));
    }
}
