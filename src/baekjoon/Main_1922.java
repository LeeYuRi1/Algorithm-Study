package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge_1922 implements Comparable<Edge_1922> {
    int end;
    int weight;

    Edge_1922(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge_1922 that) {
        return this.weight - that.weight;
    }
}

public class Main_1922 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Edge_1922>[] g = new ArrayList[n + 1];
        boolean[] check = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new Edge_1922(b, c));
            g[b].add(new Edge_1922(a, c));
        }

        PriorityQueue<Edge_1922> q = new PriorityQueue<>();
        for (Edge_1922 e : g[1]) {
            q.offer(e);
        }
        check[1] = true;
        int ans = 0;
        while (!q.isEmpty()) {
            Edge_1922 e = q.poll();
            if (!check[e.end]) {
                check[e.end] = true;
                ans += e.weight;
                for (Edge_1922 y : g[e.end]) {
                    q.offer(y);
                }
            }
        }
        System.out.println(ans);
    }
}
