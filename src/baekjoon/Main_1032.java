package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1032 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        String answer = "";
        String str0 = str[0];
        for (int i = 0; i < str[0].length(); i++) {
            int count = 1;
            for (int j = 1; j < n; j++) {
                if (str0.charAt(i) == str[j].charAt(i)) count++;
            }
            if (count == n) answer += str0.charAt(i);
            else answer += "?";
        }
        System.out.println(answer);
    }
}
