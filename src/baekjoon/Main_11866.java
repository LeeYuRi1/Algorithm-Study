package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_11866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int count = 1;
        while (queue.size() > 0) {
            if (count == k) {
                sb.append(queue.poll());
                count = 1;
                if (queue.size() > 0) sb.append(", ");
            } else {
                count++;
                queue.offer(queue.poll());
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
