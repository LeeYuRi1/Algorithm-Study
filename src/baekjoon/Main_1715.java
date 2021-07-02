package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1715 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (n-- > 0) pq.offer(Integer.parseInt(br.readLine()));
        int ans = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            ans += (a + b);
            pq.offer(a + b);
        }
        System.out.println(ans);
    }
}
