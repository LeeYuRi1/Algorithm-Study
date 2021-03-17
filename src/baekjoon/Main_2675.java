package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2675 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            String s = input[1];
            String answer = "";
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < Integer.parseInt(input[0]); j++) {
                    answer += s.charAt(i);
                }
            }
            System.out.println(answer);
        }
    }
}
