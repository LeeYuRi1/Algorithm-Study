package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1769 {

    private static String answer = "NO";
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        countMultipleOf3(n);
        System.out.println(count);
        System.out.println(answer);
    }

    private static void countMultipleOf3(String n) {
        if (n.length() == 1) {
            if (Integer.parseInt(n) % 3 == 0) answer = "YES";
            return;
        }
        count++;
        countMultipleOf3(convertN(n));
    }

    private static String convertN(String n) {
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += n.charAt(i) - '0';
        }
        return sum + "";
    }
}
