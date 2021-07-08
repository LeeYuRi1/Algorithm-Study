package template.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 1차원에서의 bfs(예제 설명: 백준 1697)
public class Bfs_5 {
    public static void main(String[] args) {
        int n = 5;
        int k = 17;
        int[] time = new int[100002];
        Arrays.fill(time, -1); // -1로 초기화
        bfs(time, n, k);
        System.out.println(time[k]);
    }

    private static void bfs(int[] time, int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        time[n] = 0;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            if (p == k) return;
            int[] op = {p - 1, p + 1, p * 2};
            for (int i : op) {
                if (i < 0 || i > 100000) continue; // 범위를 벗어나면 넘어가기
                if (time[i] != -1) continue; // 이미 방문했다면 넘어가기
                queue.offer(i);
                time[i] = time[p] + 1;
            }
        }
    }
}
