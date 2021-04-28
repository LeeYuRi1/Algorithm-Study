package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1946 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ranks = new int[n];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                ranks[Integer.parseInt(s[0]) - 1] = Integer.parseInt(s[1]);
            }
            int count = 0;
            int min = ranks[0];
            for (int i = 1; i < n; i++) {
                if (ranks[i] > min) {
                    count++;
                } else {
                    min = Math.min(min, ranks[i]);
                }
            }
            sb.append(n - count + "\n");
        }
        System.out.println(sb);
    }
}
