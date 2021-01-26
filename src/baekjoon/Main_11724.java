package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

// 연결 요소
public class Main_11724 {

    static private ArrayList<Integer>[] a;
    static private boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        a = new ArrayList[n + 1];
        check = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
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
