package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_13913 {
    private static int[] path = new int[100002];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        Arrays.fill(path, -1);
        bfs(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        print(Integer.parseInt(s[1]));
    }

    private static void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int[] time = new int[100002];
        queue.offer(n);
        Arrays.fill(time, -1);
        time[n] = 0;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            if (p == k) {
                sb.append(time[p] + "\n");
                return;
            }
            int[] dx = {p - 1, p + 1, p * 2};
            for (int i : dx) {
                if (i < 0 || i > 100000) continue;
                if (time[i] != -1) continue;
                queue.offer(i);
                time[i] = time[p] + 1;
                path[i] = p;
            }
        }
    }

    private static void print(int k) {
        Stack<Integer> stack = new Stack<>();
        while (k != -1) {
            stack.push(k);
            k = path[k];
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb);
    }
}
