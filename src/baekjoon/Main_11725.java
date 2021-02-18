package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_11725 {

    static private ArrayList<Integer>[] a;
    static private boolean[] check;
    static private int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new ArrayList[n + 1];
        check = new boolean[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }

        bfs();

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        check[1] = true;
        while (!queue.isEmpty()) {
            int x = queue.remove();
            for (int y : a[x]) {
                if (!check[y]) {
                    check[y] = true;
                    parent[y] = x;
                    queue.add(y);
                }
            }
        }
    }
}
