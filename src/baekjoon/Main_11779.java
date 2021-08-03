package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

class Pair_11779 implements Comparable<Pair_11779> {
    int v;
    int w;

    public Pair_11779(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Pair_11779 o) {
        return this.w - o.w;
    }
}

public class Main_11779 {
    private static ArrayList<Pair_11779>[] arr;
    private static int[] dist;
    private static boolean[] check;
    private static int[] path;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        dist = new int[n + 1];
        check = new boolean[n + 1];
        path = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = new ArrayList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);
        while (m-- > 0) {
            String[] s2 = br.readLine().split(" ");
            int a = Integer.parseInt(s2[0]);
            int b = Integer.parseInt(s2[1]);
            int c = Integer.parseInt(s2[2]);
            arr[a].add(new Pair_11779(b, c));
        }
        String[] s3 = br.readLine().split(" ");
        int start = Integer.parseInt(s3[0]);
        int end = Integer.parseInt(s3[1]);
        dijkstra(start);
        print(end);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Pair_11779> pq = new PriorityQueue<>();
        pq.offer(new Pair_11779(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Pair_11779 p = pq.poll();
            int x = p.v;
            if (check[x]) continue; // 이 부분 없으면 시간초과!
            check[x] = true;
            for (Pair_11779 y : arr[x]) {
                if (dist[y.v] > dist[x] + y.w) {
                    dist[y.v] = dist[x] + y.w;
                    path[y.v] = x;
                    pq.offer(new Pair_11779(y.v, dist[y.v]));
                }
            }
        }
    }

    // 역추적 - 스택 사용
    private static void print(int end) {
        StringBuilder sb = new StringBuilder();
        sb.append(dist[end] + "\n");
        Stack<Integer> stack = new Stack<>();
        while (end != -1) {
            stack.push(end);
            end = path[end];
        }
        sb.append(stack.size() + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb);
    }
}
