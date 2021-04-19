package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2606 {

    private static ArrayList<Integer>[] a;
    private static boolean[] check;
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        a = new ArrayList[n + 1];
        check = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
            check[i] = false;
        }
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            a[u].add(v);
            a[v].add(u);
        }
        dfs(1);
        System.out.println(count - 1);
    }

    private static void dfs(int x) {
        check[x] = true;
        count++;
        for (int y : a[x]) {
            if (!check[y]) dfs(y);
        }
    }
}
