package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14889 {
    private static int n, ans = Integer.MAX_VALUE;
    private static int[][] num;
    private static boolean[] team;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n][n];
        team = new boolean[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                num[i][j] = Integer.parseInt(input[j]);
            }
        }
        divideTeam(0, 0);
        System.out.println(ans);
    }

    private static void divideTeam(int depth, int start) {
        if (depth == n / 2) {
            ans = Math.min(ans, Math.abs(sumValue(true) - sumValue(false)));
            return;
        }
        for (int i = start; i < n; i++) {
            team[i] = true;
            divideTeam(depth + 1, i + 1);
            team[i] = false;
        }
    }

    private static int sumValue(boolean teamValue) {
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (team[i] != teamValue) continue;
            for (int j = i + 1; j < n; j++) {
                if (team[j] != teamValue) continue;
                result += num[i][j] + num[j][i];
            }
        }
        return result;
    }
}
