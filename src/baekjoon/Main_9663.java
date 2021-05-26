package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9663 {
    private static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            int[] col = new int[n + 1]; //index:행, value:열
            col[1] = i; //1행 i열
            dfs(col, 1, n);
        }
        System.out.println(ans);
    }

    private static void dfs(int[] col, int l, int n) {
        if (l == n) ans++;
        else {
            for (int i = 1; i <= n; i++) {
                col[l + 1] = i;
                if (isPossible(col, l + 1)) {
                    dfs(col, l + 1, n);
                } else {
                    col[l + 1] = 0;
                }
            }
        }
        col[l] = 0;
    }

    private static boolean isPossible(int[] col, int l) {
        for (int i = 1; i < l; i++) {
            if (col[i] == col[l]) return false;
            if (Math.abs(i - l) == Math.abs(col[i] - col[l])) return false;
        }
        return true;
    }
}
