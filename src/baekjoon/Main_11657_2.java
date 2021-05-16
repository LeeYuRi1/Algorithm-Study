package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge_11657_2 {
    int to;
    int cost;

    Edge_11657_2(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

// SPFA 사용
public class Main_11657_2 {
    private static ArrayList<Edge_11657_2>[] g;
    private static long[] d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        g = new ArrayList[n + 1];
        d = new long[n + 1];
        int inf = 100000000;
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
            d[i] = inf;
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new Edge_11657_2(b, c));
        }
        boolean negativeCycle = spfa(n);
        StringBuilder sb = new StringBuilder();
        if (negativeCycle) {
            sb.append(-1);
        } else {
            for (int i = 2; i <= n; i++) {
                if (d[i] == inf) d[i] = -1;
                sb.append(d[i] + "\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean spfa(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] c = new boolean[n + 1];
        int[] cycle = new int[n + 1];
        c[1] = true;
        d[1] = 0;
        while (!queue.isEmpty()) {
            int from = queue.poll();
            c[from] = false;
            for (Edge_11657_2 e : g[from]) {
                int to = e.to;
                int cost = e.cost;
                if (d[to] > d[from] + cost) {
                    d[to] = d[from] + cost;
                    if (!c[to]) {
                        cycle[to]++;
                        if (cycle[to] >= n) return true;
                        queue.offer(to);
                        c[to] = true;
                    }
                }
            }
        }
        return false;
    }
}
