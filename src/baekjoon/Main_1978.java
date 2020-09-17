package baekjoon;

import java.util.Scanner;

public class Main_1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int result = 0;

        for (int i = 0; i < count; i++) {
            int num = sc.nextInt();
            if (prime(num))
                result++;
        }
        System.out.println(result);
    }

    private static boolean prime(int num) {
        if (num == 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}
