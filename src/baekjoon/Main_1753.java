package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge_1753 implements Comparable<Edge_1753> {
    int to;
    int cost;

    Edge_1753(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_1753 o) {
        return this.cost - o.cost;
    }
}

public class Main_1753 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        int start = Integer.parseInt(br.readLine());

        ArrayList<Edge_1753>[] a = new ArrayList[v + 1];
        int[] d = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            a[i] = new ArrayList<>();
        }
        while (e-- > 0) {
            String[] input2 = br.readLine().split(" ");
            int x = Integer.parseInt(input2[0]);
            int y = Integer.parseInt(input2[1]);
            int w = Integer.parseInt(input2[2]);
            a[x].add(new Edge_1753(y, w));
        }
        dijkstra(a, d, start);
        print(d, v);
    }

    private static void dijkstra(ArrayList<Edge_1753>[] a, int[] d, int start) {
        PriorityQueue<Edge_1753> queue = new PriorityQueue<>();
        queue.add(new Edge_1753(start, 0));
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;
        while (!queue.isEmpty()) {
            Edge_1753 e = queue.poll();
            int end = e.to;
            for (Edge_1753 edge : a[end]) {
                if (d[edge.to] > d[end] + edge.cost) {
                    d[edge.to] = d[end] + edge.cost;
                    queue.add(new Edge_1753(edge.to, d[edge.to]));
                }
            }
        }
    }

    private static void print(int[] d, int v) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (d[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(d[i] + "\n");
        }
        System.out.println(sb);
    }
}
