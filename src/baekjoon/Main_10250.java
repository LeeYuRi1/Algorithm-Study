package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10250 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int h = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[2]);

            if (n % h == 0) System.out.println((h * 100) + (n / h));
            else System.out.println((n % h) * 100 + (n / h) + 1);
        }
    }
}
