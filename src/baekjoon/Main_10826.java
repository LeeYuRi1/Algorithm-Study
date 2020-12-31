package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

//재귀로 풀 경우 시간 초과
public class Main_10826 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(0);
        } else if (n == 1) {
            System.out.println(1);
        } else {
            BigInteger a = BigInteger.ZERO;
            BigInteger b = BigInteger.ONE;
            BigInteger c = BigInteger.ZERO;
            for (int i = 2; i <= n; i++) {
                c = a.add(b);
                a = b;
                b = c;
            }
            System.out.println(c);
        }
    }
}
