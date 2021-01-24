package baekjoon;


import java.util.*;

public class Main_1260 {

    static private ArrayList<Integer>[] a;
    static private boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        a = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }

        for (int i=1; i<=n; i++) {
            Collections.sort(a[i]);
        }

        check = new boolean[n + 1];
        dfs(start);
        System.out.println();
        check = new boolean[n + 1];
        bfs(start);
    }

    private static void dfs(int x) {
        if (check[x]) return;
        check[x] = true;
        System.out.print(x + " ");
        for (int y : a[x]) {
            if (!check[y]) {
                dfs(y);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        check[start] = true;

        while (!q.isEmpty()) {
            int x = q.remove();
            System.out.print(x + " ");
            for (int y : a[x]) {
                if (!check[y]) {
                    check[y] = true;
                    q.add(y);
                }
            }
        }
    }
}
