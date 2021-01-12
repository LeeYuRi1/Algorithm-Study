package baekjoon;

import java.util.Scanner;

public class Main_9613 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            System.out.println(gcdSum(a));
        }
    }

    private static long gcdSum(int[] a) {
        long sum = 0;
        for (int i = 0; i < a.length - 1; i++)
            for (int j = i + 1; j < a.length; j++)
                sum += gcd(a[i], a[j]);
        return sum;
    }

    private static int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
}
