package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge_1774 implements Comparable<Edge_1774> {
    int from;
    int to;
    double dist;

    Edge_1774(int from, int to, double dist) {
        this.from = from;
        this.to = to;
        this.dist = dist;
    }

    @Override
    public int compareTo(Edge_1774 o) {
        return Double.compare(this.dist, o.dist);
    }
}

public class Main_1774 {
    private static int N, parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] points = new int[N][2];
        parent = new int[N];
        makeSet();
        // 좌표 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        // 이미 연결된 통로
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            union(a, b);
        }

        // 간선 구하기
        List<Edge_1774> adjList = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                double d = Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                adjList.add(new Edge_1774(i, j, d));
            }
        }

        // 크루스칼
        Collections.sort(adjList);
        double ans = 0;
        int count = 0;
        for (Edge_1774 e : adjList) {
            if (union(e.from, e.to)) {
                ans += e.dist;
                if (++count == N - 1 - M) break;
            }
        }
        System.out.println(String.format("%.2f", ans));
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
