package baekjoon;

import java.util.Scanner;

public class Main_1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int l = a * b / gcd(a, b);
            System.out.println(l);
        }
    }

    private static int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
}
