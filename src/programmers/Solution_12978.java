package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// 배달
class Path_12978 implements Comparable<Path_12978> {
    int to;
    int cost;

    public Path_12978(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Path_12978 o) {
        return this.cost - o.cost;
    }
}

public class Solution_12978 {
    private static ArrayList<Path_12978>[] arr;
    private static int[] dist;
    private static boolean[] check;

    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
    }

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        arr = new ArrayList[N + 1];
        dist = new int[N + 1];
        check = new boolean[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            arr[a].add(new Path_12978(b, c));
            arr[b].add(new Path_12978(a, c));
        }
        Arrays.fill(dist, 100000000);
        dijkstra(1);
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        return answer;
    }

    private static void dijkstra(int start) {
        PriorityQueue<Path_12978> pq = new PriorityQueue<>();
        pq.offer(new Path_12978(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Path_12978 p = pq.poll();
            int x = p.to;
            if (check[x]) continue;
            check[x] = true;
            for (Path_12978 y : arr[x]) {
                if (dist[y.to] > dist[x] + y.cost) {
                    dist[y.to] = dist[x] + y.cost;
                    pq.offer(new Path_12978(y.to, dist[y.to]));
                }
            }
        }
    }
}
