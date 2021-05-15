package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1697 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        System.out.println(bfs(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
    }

    private static int bfs(int n, int m) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int[] c = new int[100002];
        Arrays.fill(c, -1);
        c[n] = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == m) return c[x];
            int[] num = new int[]{x - 1, x + 1, x * 2};
            for (int i : num) {
                if (i < 0 || i > 100000) continue;
                if (c[i] == -1) {
                    queue.offer(i);
                    c[i] = c[x] + 1;
                }
            }
        }
        return c[m];
    }
}
