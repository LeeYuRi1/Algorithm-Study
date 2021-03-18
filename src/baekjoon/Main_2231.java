package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2231 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            int m = i;
            int sum = m;
            while (m > 0) {
                sum += m%10;
                m/=10;
            }
            if (sum == n) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
