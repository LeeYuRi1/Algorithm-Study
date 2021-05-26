package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_15650 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] arr = new int[m];
        dfs(arr, 1, 0, n, m);
        System.out.println(sb);
    }

    private static void dfs(int[] arr, int i, int depth, int n, int m) {
        if (depth == m) {
            for (int j : arr) sb.append(j + " ");
            sb.append("\n");
            return;
        }
        for (int j = i; j <= n; j++) {
            arr[depth] = j;
            dfs(arr, j + 1, depth + 1, n, m);
        }
    }
}
