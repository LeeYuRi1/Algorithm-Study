package baekjoon;

import java.util.Scanner;

public class Main_2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int gcdNum = gcd_recursion(num1, num2);
        int lcmNum = num1 * num2 / gcdNum; // 최소공배수

        System.out.println(gcdNum);
        System.out.println(lcmNum);
    }

    // 최대공약수 방법 1
    private static int gcd_while(int num1, int num2) {
        while (num2 != 0) {
            int r = num1 % num2;
            num1 = num2;
            num2 = r;
        }
        return num1;
    }

    // 최대공약수 방법 2
    private static int gcd_recursion(int num1, int num2) {
        if (num2 == 0) return num1;
        return gcd_recursion(num2, num1 % num2);
    }
}
