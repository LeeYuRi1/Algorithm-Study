package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_15829 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long sum = 0;
        long mul = 1;
        int m = 1234567891;
        for (int i = 0; i < n; i++) {
            sum += ((s.charAt(i) - 96) * mul) % m;
            mul = (mul * 31) % m;
        }
        System.out.println(sum % m);
    }
}
