package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_15649 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] arr = new int[m];
        boolean[] visit = new boolean[n + 1];
        dfs(arr, visit, 0, n, m);
        System.out.println(sb);
    }

    private static void dfs(int[] arr, boolean[] visit, int depth, int n, int m) {
        if (depth == m) {
            for (int j : arr) sb.append(j + " ");
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i;
                dfs(arr, visit, depth + 1, n, m);
                visit[i] = false;
            }
        }
    }
}
