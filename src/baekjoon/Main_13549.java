package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_13549 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        System.out.println(bfs(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
    }

    private static int bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[100002];
        int[] time = new int[100002];
        queue.offer(n);
        check[n] = true;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            if (p == k) return time[p];
            int[] dx = {p * 2, p - 1, p + 1}; // *2하는 시간이 더 빠르므로 앞에 둠
            for (int i = 0; i < 3; i++) {
                if (dx[i] < 0 || dx[i] > 100000) continue;
                if (check[dx[i]]) continue;
                queue.offer(dx[i]);
                check[dx[i]] = true;
                if (i == 0) time[dx[i]] = time[p];
                else time[dx[i]] = time[p] + 1;
            }
        }
        return time[k];
    }
}
