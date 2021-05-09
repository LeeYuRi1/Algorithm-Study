package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge_1916_2 implements Comparable<Edge_1916_2> {
    int to;
    int cost;

    Edge_1916_2(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_1916_2 o) {
        return this.cost - o.cost;
    }
}

// 다익스트라 - 우선순위 큐 이용
public class Main_1916_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Edge_1916_2>[] a = new ArrayList[n + 1];
        int[] d = new int[n + 1];
        boolean[] c = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            a[x].add(new Edge_1916_2(y, w));
        }
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        dijkstra(a, d, c, start);
        System.out.println(d[end]);
    }

    private static void dijkstra(ArrayList<Edge_1916_2>[] a, int[] d, boolean[] c, int start) {
        PriorityQueue<Edge_1916_2> queue = new PriorityQueue<>();
        queue.add(new Edge_1916_2(start, 0));
        Arrays.fill(d, 100000000);
        d[start] = 0;
        while (!queue.isEmpty()) {
            Edge_1916_2 e = queue.poll();
            int end = e.to;
            if (!c[end]) {
                c[end] = true;
                for (Edge_1916_2 edge : a[end]) {
                    if (!c[edge.to] && d[edge.to] > d[end] + edge.cost) {
                        d[edge.to] = d[end] + edge.cost;
                        queue.add(new Edge_1916_2(edge.to, d[edge.to]));
                    }
                }
            }
        }
    }
}
