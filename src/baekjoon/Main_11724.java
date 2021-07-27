package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 연결 요소
public class Main_11724 {

    static private ArrayList<Integer>[] a;
    static private boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        a = new ArrayList[n + 1];
        check = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            String[] s2 = br.readLine().split(" ");
            int u = Integer.parseInt(s2[0]);
            int v = Integer.parseInt(s2[1]);
            a[u].add(v);
            a[v].add(u);
        }

        int components = 0;
        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                dfs(i);
                components++;
            }
        }
        System.out.println(components);
    }

    private static void dfs(int x) {
        check[x] = true;
        for (int y : a[x]) {
            if (!check[y]) dfs(y);
        }
    }
}
