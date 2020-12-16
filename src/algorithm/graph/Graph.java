package algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//수정 필요
public class Graph {

    private int n;
    private static ArrayList<Integer>[] adj;

    Graph(int num) {
        n = num;
        adj = new ArrayList[num];
        for (int i = 0; i < num; i++)
            adj[i] = new ArrayList<>();
    }

    public void add(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public void bfs(int s) { //출발노드 s
        Queue<Integer> q = new LinkedList<>();
        int d[] = new int[n]; //최단경로의 길이
        int p[] = new int[n]; //직전노드

        //모든 노드 u에 대해서 d[u], p[u]를 초기화
        for (int i = 0; i < n; i++) {
            d[i] = -1;
            p[i] = 0;
        }
        d[s] = 0;
        p[s] = 0;
        q.add(s);
        System.out.print(s + " ");
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) { //u에 인접한 노드 v에 대해서
                if (d[v] == -1) {
                    d[v] = d[u] + 1;
                    p[v] = u;
                    q.add(v);
                    System.out.print(v + " ");
                }
            }
        }

    }

    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.add(1, 2);
        g.add(1, 3);
        g.add(2, 4);
        g.add(2, 5);
        g.add(4, 5);
        g.add(5, 6);
        g.add(3, 5);
        g.add(3, 7);
        g.add(3, 8);
        g.add(7, 8);
        g.bfs(1);
    }
}
