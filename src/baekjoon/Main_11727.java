package baekjoon;

import java.util.Scanner;

public class Main_11727 {

    private static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[1001];
        System.out.println(tiling2(n));
    }

    private static int tiling2(int n) {
        if (n == 0 || n == 1) return 1;
        if (d[n] > 0) return d[n];
        d[n] = tiling2(n - 1) + 2 * tiling2(n - 2);
        d[n] %= 10007;
        return d[n];
    }
}
