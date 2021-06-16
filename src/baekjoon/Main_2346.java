package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_2346 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.addLast(new int[]{i + 1, Integer.parseInt(s[i])});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("1 ");
        int[] p = deque.pollFirst();
        while (!deque.isEmpty()) {
            int count = p[1];
            if (count > 0) {
                count--;
                while (count-- > 0) deque.addLast(deque.pollFirst());
                p = deque.pollFirst();
            } else {
                count = -count - 1;
                while (count-- > 0) deque.addFirst(deque.pollLast());
                p = deque.pollLast();
            }
            sb.append(p[0] + " ");
        }
        System.out.println(sb);
    }
}
