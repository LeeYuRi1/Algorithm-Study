package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_5567 {
    private static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] a = new ArrayList[n + 1];
        boolean[] check = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            String[] s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            a[u].add(v);
            a[v].add(u);
            // 상근이의 친구
            if (u == 1) {
                queue.offer(v);
                check[v] = true;
                ans++;
            }
        }
        // 상근이의 친구의 친구
        bfs(a, check, queue);
        System.out.println(ans);
    }

    private static void bfs(ArrayList<Integer>[] a, boolean[] check, Queue<Integer> queue) {
        check[1] = true;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            for (int i : a[p]) {
                if (check[i]) continue;
                check[i] = true;
                ans++;
            }
        }
    }
}
