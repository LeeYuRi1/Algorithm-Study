package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair_1916 implements Comparable<Pair_1916> {
    int to;
    int cost;

    Pair_1916(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Pair_1916 o) {
        return this.cost - o.cost;
    }
}

public class Main_1916 {
    private static ArrayList<Pair_1916>[] a;
    private static int[] dist;
    private static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        a = new ArrayList[n + 1];
        dist = new int[n + 1];
        check = new boolean[n + 1];
        for (int i = 1; i <= n; i++) a[i] = new ArrayList<>();
        Arrays.fill(dist, 100000000);

        while (m-- > 0) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);
            a[x].add(new Pair_1916(y, w));
        }
        String[] s = br.readLine().split(" ");
        dijkstra(Integer.parseInt(s[0]));
        System.out.println(dist[Integer.parseInt(s[1])]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Pair_1916> pq = new PriorityQueue<>();
        pq.offer(new Pair_1916(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Pair_1916 e = pq.poll();
            int x = e.to;
            if (check[x]) continue;
            check[x] = true;
            for (Pair_1916 y : a[x]) {
                if (dist[y.to] > dist[x] + y.cost) {
                    dist[y.to] = dist[x] + y.cost;
                    pq.offer(new Pair_1916(y.to, dist[y.to]));
                }
            }
        }
    }
}
