package baekjoon;

import java.util.Scanner;

public class Main_9613 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] result = new long[n];

        for (int i = 0; i < n; i++) {
            int testNum = sc.nextInt();
            int[] testCase = new int[testNum];

            for (int j = 0; j < testNum; j++)
                testCase[j] = sc.nextInt();
            result[i] = gcdSum(testCase);
        }

        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }

    private static long gcdSum(int[] testCase) {
        long sum = 0;
        for (int i = 0; i < testCase.length - 1; i++)
            for (int j = i + 1; j < testCase.length; j++)
                sum += gcd(testCase[i], testCase[j]);
        return sum;
    }

    private static int gcd(int num1, int num2) {
        if (num2 == 0) return num1;
        return gcd(num2, num1 % num2);
    }
}
