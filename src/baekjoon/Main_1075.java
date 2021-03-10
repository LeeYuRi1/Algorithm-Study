package baekjoon;

import java.util.Scanner;

public class Main_1075 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int f = sc.nextInt();

        String answer = "";
        long num = (n / 100) * 100;
        if (num % f == 0) {
            answer = "00";
        } else {
            long r = num / f + 1;
            answer += r * f;
            answer = answer.substring(answer.length() - 2);
        }
        System.out.println(answer);
    }
}
