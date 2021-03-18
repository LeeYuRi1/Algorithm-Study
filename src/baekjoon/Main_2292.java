package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2292 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(1);
            return;
        }

        int mul = 2;
        int num = 7;
        while (true) {
            if (n <= num) {
                System.out.println(mul);
                break;
            }
            num += 6 * mul;
            mul++;
        }
    }
}
