package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge_2406 implements Comparable<Edge_2406> {
    int from;
    int to;
    int cost;

    Edge_2406(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_2406 o) {
        return this.cost - o.cost;
    }
}

public class Main_2406 {
    private static int N, parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        makeSet();

        int count = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            if (union(x, y)) count++;
        }

        List<Edge_2406> edgeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            if (i == 0) continue;
            for (int j = i + 1; j < N; j++) {
                edgeList.add(new Edge_2406(i, j, Integer.parseInt(input[j])));
            }
        }

        Collections.sort(edgeList);
        int ans = 0, ansCount = 0;
        StringBuilder sb = new StringBuilder();
        for (Edge_2406 e : edgeList) {
            if (union(e.from, e.to)) {
                ans += e.cost;
                ansCount++;
                sb.append(e.from + 1).append(" ").append(e.to + 1).append("\n");
                if (++count == N - 1) break;
            }
        }
        System.out.println(ans + " " + ansCount);
        System.out.println(sb);
    }

    private static void makeSet() {
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    private static int findSet(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findSet(parent[x]);
    }

    private static boolean union(int x, int y) {
        int rx = findSet(x);
        int ry = findSet(y);
        if (rx == ry) return false;
        parent[ry] = rx;
        return true;
    }
}