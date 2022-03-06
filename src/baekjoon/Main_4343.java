package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge_4343 implements Comparable<Edge_4343> {
    int from;
    int to;
    double dist;

    Edge_4343(int from, int to, double dist) {
        this.from = from;
        this.to = to;
        this.dist = dist;
    }

    @Override
    public int compareTo(Edge_4343 o) {
        return Double.compare(this.dist, o.dist);
    }
}

public class Main_4343 {
    private static int P, parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            int[][] points = new int[P][2];
            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }

            List<Edge_4343> edgeList = new ArrayList<>();
            for (int i = 0; i < P - 1; i++) {
                for (int j = i + 1; j < P; j++) {
                    double d = Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                    edgeList.add(new Edge_4343(i, j, d));
                }
            }

            makeSet();
            Collections.sort(edgeList);
            double ans = 0;
            int count = 0;
            for (Edge_4343 e : edgeList) {
                if (union(e.from, e.to)) {
                    ans = Math.max(ans, e.dist);
                    if (++count == P - S) break;
                }
            }
            sb.append(String.format("%.2f", ans)).append("\n");
        }
        System.out.println(sb);
    }

    private static void makeSet() {
        parent = new int[P];
        for (int i = 0; i < P; i++) {
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
