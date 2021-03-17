package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_8958 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String input = br.readLine();
            int score = 0;
            int sum = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'O') {
                    score++;
                    sum += score;
                } else {
                    score = 0;
                }
            }
            System.out.println(sum);
        }
    }
}
