package baekjoon;

import java.util.Scanner;

public class Main_11576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = sc.nextInt();

        int answer = 0;
        while (m-- > 0) {
            int n = sc.nextInt();
            // a진법 -> 10진법
            answer = answer * a + n;
        }
        convertB(answer, b);
    }

    // 10진법 -> b진법
    private static void convertB(int n, int b) {
        String result = "";
        while (n > 0) {
            int r = n % b;
            n /= b;
            result = r + " " + result;
        }
        System.out.println(result);
    }

}
