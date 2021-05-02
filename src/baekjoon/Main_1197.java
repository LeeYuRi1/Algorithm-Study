package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge_1197 implements Comparable<Edge_1197> {
    int end;
    int weight;

    Edge_1197(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge_1197 that) {
        return this.weight - that.weight;
    }
}

public class Main_1197 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        ArrayList<Edge_1197>[] g = new ArrayList[v + 1];
        boolean[] check = new boolean[v + 1];
        for (int i = 1; i <= v; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new Edge_1197(b, c));
            g[b].add(new Edge_1197(a, c));
        }

        PriorityQueue<Edge_1197> q = new PriorityQueue<>();
        for (Edge_1197 edge : g[1]) {
            q.offer(edge);
        }
        check[1] = true;
        int ans = 0;
        while (!q.isEmpty()) {
            Edge_1197 edge = q.poll();
            if (!check[edge.end]) {
                check[edge.end] = true;
                ans += edge.weight;
                for (Edge_1197 y : g[edge.end]) {
                    q.offer(y);
                }
            }
        }
        System.out.println(ans);
    }
}
