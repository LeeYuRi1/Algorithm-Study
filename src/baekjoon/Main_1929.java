package baekjoon;

import java.util.Scanner;

public class Main_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        for (int i = num1; i <= num2; i++) {
            boolean isPrime = true;
            if (i == 1) isPrime = false;
            for (int j = 2; j * j <= i && isPrime; j++) {
                if (i % j == 0) isPrime = false;
            }
            if (isPrime) System.out.println(i);
        }

    }
}
