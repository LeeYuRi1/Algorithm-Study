package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

class Edge_11779 implements Comparable<Edge_11779> {
    int to;
    int cost;

    Edge_11779(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_11779 o) {
        return this.cost = o.cost;
    }
}

public class Main_11779 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Edge_11779>[] a = new ArrayList[n + 1];
        int[] d = new int[n + 1];
        int[] v = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            a[x].add(new Edge_11779(y, w));
        }
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        dijkstra(a, d, v, start);
        print(d, v, end);
    }

    private static void dijkstra(ArrayList<Edge_11779>[] a, int[] d, int[] v, int start) {
        PriorityQueue<Edge_11779> queue = new PriorityQueue<>();
        queue.add(new Edge_11779(start, 0));
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;
        v[start] = 0;
        while (!queue.isEmpty()) {
            Edge_11779 e = queue.poll();
            int end = e.to;
            for (Edge_11779 edge : a[end]) {
                if (d[edge.to] > d[end] + edge.cost) {
                    d[edge.to] = d[end] + edge.cost;
                    queue.add(new Edge_11779(edge.to, d[edge.to]));
                    v[edge.to] = end;
                }
            }
        }
    }

    private static void print(int[] d, int[] v, int end) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int x = end;
        while (x != 0) {
            stack.push(x);
            x = v[x];
        }
        sb.append(d[end] + "\n");
        sb.append(stack.size() + "\n");
        while (!stack.empty()) {
            sb.append(stack.peek() + " ");
            stack.pop();
        }
        System.out.println(sb);
    }
}
