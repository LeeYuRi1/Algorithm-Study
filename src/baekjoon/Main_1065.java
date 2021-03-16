package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1065 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i < 100) count++;
            else {
                String s = i + "";
                int r1 = Integer.parseInt(s.substring(0, 1));
                int r2 = Integer.parseInt(s.substring(1, 2));
                int r3 = Integer.parseInt(s.substring(2, 3));
                if (r2 - r1 == r3 - r2) count++;
            }
        }
        System.out.println(count);
    }
}
