package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2644 {
    private static int n;
    private static ArrayList<Integer>[] a;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }
        String[] input1 = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            String[] input2 = br.readLine().split(" ");
            int x = Integer.parseInt(input2[0]);
            int y = Integer.parseInt(input2[1]);
            a[x].add(y);
            a[y].add(x);
        }
        System.out.println(bfs(Integer.parseInt(input1[0]), Integer.parseInt(input1[1])));
    }

    private static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[start] = 0;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            if (p == end) return dist[end];
            for (int i : a[p]) {
                if (dist[i] != -1) continue;
                dist[i] = dist[p] + 1;
                queue.offer(i);
            }
        }
        return dist[end];
    }
}
