package baekjoon;

import java.util.Scanner;

public class Main_2748 {

    public static long[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new long[n+1];
        System.out.println(fibonacci(n));
    }

    private static long fibonacci(int n) {
        if (n <= 1) return n;
        if (d[n] > 0) return d[n];
        d[n] = fibonacci(n-1) + fibonacci(n-2);
        return d[n];
    }
}
