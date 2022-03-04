package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge_1647 implements Comparable<Edge_1647> {
    int from;
    int to;
    int cost;

    Edge_1647(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_1647 o) {
        return this.cost - o.cost;
    }
}

public class Main_1647 {
    private static int N, parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Edge_1647> edgeList = new ArrayList<>();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge_1647(a, b, c));
        }
        parent = new int[N + 1];
        makeSet();
        Collections.sort(edgeList);
        int count = 0, sum = 0, max = 0;
        for (Edge_1647 e : edgeList) {
            if (union(e.from, e.to)) {
                sum += e.cost;
                max = Math.max(max, e.cost);
                if (++count == N - 1) break;
            }
        }
        System.out.println(sum - max);
    }

    private static void makeSet() {
        for (int i = 1; i <= N; i++) {
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
