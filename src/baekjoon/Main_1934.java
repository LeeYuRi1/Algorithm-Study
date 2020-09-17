package baekjoon;

import java.util.Scanner;

public class Main_1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] result = new int[count];

        for (int i = 0; i < count; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            result[i] = a * b / gcd_recursion(a, b);
        }

        for (int i = 0; i < count; i++) {
            System.out.println(result[i]);
        }
    }

    private static int gcd_recursion(int num1, int num2) {
        if (num2 == 0) return num1;
        return gcd_recursion(num2, num1 % num2);
    }
}
