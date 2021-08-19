package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1260 {
    private static ArrayList<Integer>[] a;
    private static boolean[] check;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        int v = Integer.parseInt(input1[2]);

        a = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int v1 = Integer.parseInt(input2[0]);
            int v2 = Integer.parseInt(input2[1]);
            a[v1].add(v2);
            a[v2].add(v1);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(a[i]);
        }

        check = new boolean[n + 1];
        dfs(v);
        sb.append("\n");
        check = new boolean[n + 1];
        bfs(v);
        System.out.println(sb);
    }

    private static void dfs(int v) {
        check[v] = true;
        sb.append(v + " ");
        for (int i : a[v]) {
            if (check[i]) continue;
            dfs(i);
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        check[v] = true;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            sb.append(p + " ");
            for (int i : a[p]) {
                if (check[i]) continue;
                check[i] = true;
                queue.offer(i);
            }
        }
    }
}
