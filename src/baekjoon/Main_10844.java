package baekjoon;

import java.util.Scanner;

// d[N][L] = N자리 계단수, 마지막수: L
// d[N][L] = d[N-1][L-1] + d[N-1][L+1]
public class Main_10844 {

    public static long mod = 1000000000L;
    public static long[][] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new long[n + 1][10];
        long answer = 0;

        for (int i = 1; i <= 9; i++) {
            answer += topDown(n, i);
        }
        answer %= mod;
        System.out.println(answer);
    }

    private static long topDown(int n, int l) {
        if (n == 1) return 1;
        if (d[n][l] > 0) return d[n][l];
        if (l - 1 >= 0) {
            d[n][l] += topDown(n - 1, l - 1);
        }
        if (l + 1 <= 9) {
            d[n][l] += topDown(n - 1, l + 1);
        }
        return d[n][l] % mod;
    }

    private static void bottomUp() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] d = new long[n + 1][10];

        // 길이가 1인 경우
        for (int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                d[i][j] = 0;
                if (j - 1 >= 0) d[i][j] += d[i - 1][j - 1];
                if (j + 1 <= 9) d[i][j] += d[i - 1][j + 1];
                d[i][j] %= mod;
            }
        }

        long answer = 0;
        //길이가 n이면서 마지막수가 0부터 9까지에 대한 수를 더해서 출력
        for (int i = 0; i <= 9; i++) {
            answer += d[n][i];
        }
        answer %= mod;
        System.out.println(answer);
    }
}
