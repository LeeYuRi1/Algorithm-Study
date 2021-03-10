package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1145 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int answer = 2;
        while (true) {
            answer++;
            int count = 0;
            for (int i = 0; i < s.length; i++) {
                if (answer % Integer.parseInt(s[i]) == 0) {
                    count++;
                }
            }
            if (count >= 3) break;
        }
        System.out.println(answer);
    }
}
