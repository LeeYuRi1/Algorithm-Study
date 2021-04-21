package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9466 {

    private static int[] a;
    private static int[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            a = new int[n + 1];
            check = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(s[i - 1]);
            }

            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (check[i] == 0) {
                    count += dfs(i, 1, i);
                }
            }
            System.out.println(n - count);
        }
    }

    private static int dfs(int x, int num, int start) {
        if (check[x] != 0) {
            if (x != start) return 0;
            return check[x];
        }
        check[x] = num;
        return dfs(a[x], num + 1, start);
    }
}
