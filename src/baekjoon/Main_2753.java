package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2753 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        if (n % 4 == 0) {
            if (n % 100 != 0 || n % 400 == 0) {
                answer = 1;
            }
        }
        System.out.println(answer);
    }
}
