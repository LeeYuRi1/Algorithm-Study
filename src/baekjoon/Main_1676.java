package baekjoon;

import java.util.Scanner;

public class Main_1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        for (int i = 5; i <= n; i *= 5) {
            answer += n / i;
        }
        System.out.println(answer);
    }
}
