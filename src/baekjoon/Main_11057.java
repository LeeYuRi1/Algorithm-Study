package baekjoon;

import java.util.Scanner;

// d[N][L] = N자리 오르막수, 마지막수: L
// d[N][L] = D[N-1][K] (0 <= K <= L)
public class Main_11057 {

    public static long mod = 10007L;
    public static long[][] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new long[n + 1][11];
        long answer = 0;

        for (int i = 0; i <= 9; i++) {
            answer += topDown(n, i);
        }
        answer %= mod;
        System.out.println(answer);
    }

    private static long topDown(int n, int l) {
        if (n == 1) return 1;
        if (d[n][l] > 0) return d[n][l];

        for (int k = 0; k <= l; k++) {
            d[n][l] += topDown(n - 1, k);
        }
        return d[n][l] % mod;
    }
}
