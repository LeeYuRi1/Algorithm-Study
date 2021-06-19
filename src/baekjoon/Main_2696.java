package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2696 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int m = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            sb.append((m + 1) / 2);
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (i % 10 == 0) st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());

                if (min.size() == max.size()) max.offer(x);
                else min.offer(x);

                if (!max.isEmpty() && !min.isEmpty()) {
                    if (max.peek() > min.peek()) {
                        int p1 = min.poll();
                        int p2 = max.poll();
                        min.offer(p2);
                        max.offer(p1);
                    }
                }
                if (i % 2 == 0) {
                    if (count % 10 == 0) sb.append("\n");
                    sb.append(max.peek() + " ");
                    count++;
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
