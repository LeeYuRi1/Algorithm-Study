package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2577 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int mul = a * b * c;
        for (int i = 0; i < 10; i++) {
            String s = mul + "";
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) - '0' == i) count++;
            }
            System.out.println(count);
        }
    }
}
