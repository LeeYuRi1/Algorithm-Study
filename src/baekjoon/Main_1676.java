package baekjoon;

import java.util.Scanner;

public class Main_1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int answer2 = 0;
        int answer5 = 0;

        for (int i = 2; i <= n; i *= 2)
            answer2 += n / i;

        for (int i = 5; i <= n; i *= 5)
            answer5 += n / i;

        System.out.println(Math.min(answer2, answer5));
    }
}
