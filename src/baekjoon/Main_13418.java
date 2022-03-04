package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge_13418 {
    int v;
    int w;

    Edge_13418(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

public class Main_13418 {
    private static List<Edge_13418>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new Edge_13418(b, c));
            adjList[b].add(new Edge_13418(a, c));
        }
        PriorityQueue<Edge_13418> pq1 = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        PriorityQueue<Edge_13418> pq2 = new PriorityQueue<>((o1, o2) -> o2.w - o1.w);
        System.out.println(getDist(pq1, new boolean[N + 1]) - getDist(pq2, new boolean[N + 1]));
    }

    private static int getDist(PriorityQueue<Edge_13418> pq, boolean[] visited) {
        pq.offer(new Edge_13418(0, 1));
        int count = 0;
        while (!pq.isEmpty()) {
            Edge_13418 cur = pq.poll();
            if (visited[cur.v]) continue;
            visited[cur.v] = true;
            if (cur.w == 0) count++;
            for (Edge_13418 next : adjList[cur.v]) {
                pq.offer(next);
            }
        }
        return count * count;
    }
}
