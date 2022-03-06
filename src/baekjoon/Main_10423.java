package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge_10423 implements Comparable<Edge_10423> {
    int u, v, w;

    Edge_10423(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge_10423 o) {
        return this.w - o.w;
    }
}

public class Main_10423 {
    private static int N, parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        makeSet();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            parent[Integer.parseInt(st.nextToken())] = 0;
        }

        List<Edge_10423> edgeList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge_10423(u, v, w));
        }

        Collections.sort(edgeList);
        int ans = 0, count = 0;
        for (Edge_10423 e : edgeList) {
            if (union(e.u, e.v)) {
                ans += e.w;
                if (++count == N - K) break;
            }
        }
        System.out.println(ans);
    }

    private static void makeSet() {
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
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
