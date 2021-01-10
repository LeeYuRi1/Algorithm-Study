package baekjoon;

import java.util.Scanner;

// d[n] = n을 1,2,3의 조합으로 나타내는 방법의 수
// d[n] = d[n-1] + d[n-2] + d[n-3]
// 시간복잡도: O(N)
public class Main_9095 {

    private static int[] d = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(combination(n));
        }

    }

    private static int combination(int n) {
        if (n == 1 || n == 2) return n;
        if (n == 3) return 4;
        if (d[n] > 0) return d[n];
        d[n] = combination(n - 1) + combination(n - 2) + combination(n - 3);
        return d[n];
    }
}
