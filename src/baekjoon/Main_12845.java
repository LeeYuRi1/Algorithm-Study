package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_12845 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        PriorityQueue<Integer> level = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            level.offer(Integer.parseInt(s[i]));
        }
        int ans = 0;
        while (level.size() > 1) {
            int c1 = level.poll();
            int c2 = level.poll();
            int x = Math.max(c1, c2);
            ans += c1 + c2;
            level.offer(x);
        }
        System.out.println(ans);
    }
}
