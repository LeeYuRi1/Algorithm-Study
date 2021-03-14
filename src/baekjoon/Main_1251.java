package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1251 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String answer = "z";
        for (int i = 1; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String a = reverse(s.substring(0, i));
                String b = reverse(s.substring(i, j));
                String c = reverse(s.substring(j));
                if (answer.compareTo(a + b + c) > 0) answer = a + b + c;
            }
        }
        System.out.println(answer);
    }

    private static String reverse(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }
}
