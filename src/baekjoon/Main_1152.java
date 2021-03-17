package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1152 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int answer = input.length;
        if (answer > 0 && input[0].length() == 0) {
            answer--;
        }
        System.out.println(answer);
    }
}
