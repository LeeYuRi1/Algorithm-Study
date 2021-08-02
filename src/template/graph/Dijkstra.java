package template.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// 다익스트라 (예제 설명: 백준 1916)
// 시간 복잡도: O(ElogE)
// 음수가 있을 때 사용 불가
// 모든 간선에 대해서 한 번씩 검사
class Pair_Dijkstra implements Comparable<Pair_Dijkstra> {
    int to;
    int cost;

    Pair_Dijkstra(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Pair_Dijkstra o) {
        return this.cost - o.cost; // 오름차순
    }
}

public class Dijkstra {
    private static ArrayList<Pair_Dijkstra>[] a;
    private static int[] dist;
    private static boolean[] check;

    public static void main(String[] args) {
        int n = 5; // 정점 개수
        int m = 8; // 간선 개수
        a = new ArrayList[n + 1]; // 인접 리스트 사용
        dist = new int[n + 1]; // 최단거리를 저장하는 배열
        check = new boolean[n + 1]; // 방문했는지 확인하는 배열
        for (int i = 1; i <= n; i++) a[i] = new ArrayList<>();
        Arrays.fill(dist, 100000000); // dist를 무한대로 초기화

        a[1].add(new Pair_Dijkstra(2, 2));
        a[1].add(new Pair_Dijkstra(3, 3));
        a[1].add(new Pair_Dijkstra(4, 1));
        a[1].add(new Pair_Dijkstra(5, 10));
        a[2].add(new Pair_Dijkstra(4, 2));
        a[3].add(new Pair_Dijkstra(4, 1));
        a[3].add(new Pair_Dijkstra(5, 1));
        a[4].add(new Pair_Dijkstra(5, 3));

        int start = 1;
        int end = 5;
        dijkstra(start);
        System.out.println(dist[end]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Pair_Dijkstra> pq = new PriorityQueue<>();
        pq.offer(new Pair_Dijkstra(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Pair_Dijkstra p = pq.poll();
            int x = p.to;
            if (check[x]) continue; // 이미 방문했으면 넘어가기
            check[x] = true;
            for (Pair_Dijkstra y : a[x]) { // 연결된 정점들 탐색
                if (dist[y.to] > dist[x] + y.cost) { // 현재 dist+cost가 이미 있는 dist보다 작으면 최단경로이므로 변경
                    dist[y.to] = dist[x] + y.cost;
                    pq.offer(new Pair_Dijkstra(y.to, dist[y.to]));
                }
            }
        }
    }
}
