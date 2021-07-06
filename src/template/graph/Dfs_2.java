package template.graph;

import java.util.ArrayList;

public class Dfs_2 {
    public static void main(String[] args) {
        int n = 6;
        ArrayList<Integer>[] a = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }
        a[1].add(2);
        a[2].add(1); // 양방향 그래프
        a[2].add(5);
        a[5].add(2);
        a[5].add(1);
        a[1].add(5);
        a[3].add(4);
        a[4].add(3);
        a[4].add(6);
        a[6].add(4);

        boolean[] check = new boolean[n + 1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                dfs(a, check, i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(ArrayList<Integer>[] a2, boolean[] check, int x) {
        check[x] = true;
        for (int y : a2[x]) {
            if (!check[y]) {
                dfs(a2, check, y);
            }
        }
    }
}
