package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge_1504 implements Comparable<Edge_1504> {
    int to;
    int cost;

    Edge_1504(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_1504 o) {
        return this.cost - o.cost;
    }
}

public class Main_1504 {
    private static ArrayList<Edge_1504>[] a;
    private static int n;
    private static int inf = 200000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        a = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int x = Integer.parseInt(input2[0]);
            int y = Integer.parseInt(input2[1]);
            int w = Integer.parseInt(input2[2]);
            a[x].add(new Edge_1504(y, w));
            a[y].add(new Edge_1504(x, w));
        }
        String[] input3 = br.readLine().split(" ");
        int v1 = Integer.parseInt(input3[0]);
        int v2 = Integer.parseInt(input3[1]);

        int ans1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
        int ans2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);
        int ans = Math.min(ans1, ans2);
        if (ans >= inf) System.out.println(-1);
        else System.out.println(ans);
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Edge_1504> queue = new PriorityQueue<>();
        queue.offer(new Edge_1504(start, 0));
        int[] d = new int[n + 1];
        Arrays.fill(d, inf);
        d[start] = 0;
        while (!queue.isEmpty()) {
            Edge_1504 e = queue.poll();
            int x = e.to;
            for (Edge_1504 y : a[x]) {
                if (d[y.to] > d[x] + y.cost) {
                    d[y.to] = d[x] + y.cost;
                    queue.offer(new Edge_1504(y.to, d[y.to]));
                }
            }
        }
        return d[end];
    }
}
