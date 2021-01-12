package baekjoon;

import java.util.Scanner;

public class Main_2839 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;

        while (true) {
            if (n < 0) {
                System.out.println(-1);
                break;
            }
            if (n % 5 == 0) {
                answer += n / 5;
                System.out.println(answer);
                break;
            }
            n -= 3;
            answer++;
        }
    }
}
