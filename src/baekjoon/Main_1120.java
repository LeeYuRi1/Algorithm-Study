package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1120 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String a = input[0];
        String b = input[1];

        int min = 50;
        for (int i = 0; i <= b.length() - a.length(); i++) {
            String s = b.substring(i, i + a.length());
            int count = 0;
            for (int j = 0; j < a.length(); j++) {
                if (s.charAt(j) != a.charAt(j)) count++;
            }
            if (count < min) min = count;
        }
        System.out.println(min);
    }
}
