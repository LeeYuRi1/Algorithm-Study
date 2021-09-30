package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pair implements Comparable<Pair> {
    int start;
    int end;
    double dist;

    public Pair(int start, int end, double dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }

    @Override
    public int compareTo(Pair o) {
        return Double.compare(this.dist, o.dist);
    }
}

public class Main_4386 {
    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[][] start = new double[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            start[i][0] = Double.parseDouble(input[0]);
            start[i][1] = Double.parseDouble(input[1]);
        }
        List<Pair> pairList = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = Math.sqrt(Math.pow(start[i][0] - start[j][0], 2) + Math.pow(start[i][1] - start[j][1], 2));
                pairList.add(new Pair(i, j, dist));
            }
        }
        Collections.sort(pairList);
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        double ans = 0;
        for (int i = 0; i < pairList.size(); i++) {
            Pair p = pairList.get(i);
            if (find(p.start) == find(p.end)) continue;
            union(p.start, p.end);
            ans += p.dist;
        }
        System.out.println(String.format("%.2f", ans));
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }
}
