package baekjoon;

import java.util.Scanner;

// d[n] = n자리 이친수
// 1. n번째 자리에 0이 오는 경우, 2. n번째 자리에 1이 오는 경우
// d[n] = d[n-1] + d[n-2]
public class Main_2193 {

    private static long[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new long[n+1];
        System.out.println(pinary(n));
    }

    private static long pinary(int n) {
        if (n<=1) return n;
        if (d[n] > 0) return d[n];
        d[n] = pinary(n-1) + pinary(n-2);
        return d[n];
    }
}
