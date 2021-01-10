package baekjoon;

import java.util.Scanner;

// d[n] = 2*n을 채우는 방법의 수
// d[n] = d[n-1] + d[n-2]
public class Main_11726 {

    private static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[1001];
        System.out.println(tiling(n));
    }

    private static int tiling(int n) {
        if (n == 0 || n == 1) return 1;
        if (d[n] > 0) return d[n];
        d[n] = tiling(n - 1) + tiling(n - 2);
        d[n] %= 10007;
        return d[n];
    }
}
