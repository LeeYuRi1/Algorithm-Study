package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_12851 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        bfs(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
    }

    private static void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        int[] dist = new int[100002];
        int[] count = new int[100002]; // 현재 index까지 올 수 있는 방법의 수
        Arrays.fill(dist, -1);
        dist[n] = 0;
        count[n] = 1;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            int[] dx = {p - 1, p + 1, p * 2};
            for (int i : dx) {
                if (i < 0 || i > 100000) continue;
                if (dist[i] == -1) { // 방문하지 않았으면
                    queue.offer(i);
                    dist[i] = dist[p] + 1;
                    count[i] = count[p];
                } else if (dist[i] == dist[p] + 1) { // 방문 했어도 이동 거리가 같으면
                    count[i] += count[p];
                }
            }
        }
        System.out.println(dist[k]);
        System.out.println(count[k]);
    }
}
