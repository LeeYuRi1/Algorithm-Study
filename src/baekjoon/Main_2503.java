package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2503 {
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] hint = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) hint[i][j] = Integer.parseInt(s[j]);
        }
        int[] arr = new int[3];
        boolean[] visit = new boolean[9];
        permutation(arr, visit, 0, n, hint);
        System.out.println(count);
    }

    private static void permutation(int[] arr, boolean[] visit, int depth, int n, int[][] hint) {
        if (depth == 3) {
            String s = "";
            for (int i : arr) s += i;
            if (check(s, n, hint)) count++;
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                permutation(arr, visit, depth + 1, n, hint);
                visit[i] = false;
            }
        }
    }

    private static boolean check(String num, int n, int[][] hint) {
        for (int i = 0; i < n; i++) {
            String h = hint[i][0] + "";
            int strike = 0;
            int ball = 0;
            for (int j = 0; j < 3; j++) { // num
                for (int k = 0; k < 3; k++) { //h
                    if (num.charAt(j) == h.charAt(k)) {
                        if (j == k) strike++;
                        else ball++;
                    }
                }
            }
            if (strike != hint[i][1] || ball != hint[i][2]) return false;
        }
        return true;
    }
}
