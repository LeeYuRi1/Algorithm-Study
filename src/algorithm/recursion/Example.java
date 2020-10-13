package algorithm.recursion;

public class Example {
    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println(power(3, 2));
        System.out.println(fibonacci(5));
        System.out.println(gcd(6, 4));
        System.out.println(length("dddd"));

        printChars("abcd");
        System.out.println();

        printCharsReverse("abcd");
        System.out.println();

        printInBinary(10);
        System.out.println();

        int[] array = {1, 2, 3, 4};
        System.out.println(sum(4, array));
    }

    // 팩토리얼
    private static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }

    // 제곱
    private static double power(double x, int n) {
        if (n == 0)
            return 1;
        else
            return x * power(x, n - 1);
    }

    // 피보나치수열
    private static int fibonacci(int n) {
        if (n < 2)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 최대공약수
    private static int gcd(int m, int n) {
        if (n == 0)
            return m;
        else
            return gcd(n, m % n);
    }

    // 문자열 길이 계산
    private static int length(String str) {
        if (str.equals(""))
            return 0;
        else
            return 1 + length(str.substring(1));
    }

    // 문자열 프린트
    private static void printChars(String str) {
        if (str.length() == 0)
            return;
        else {
            System.out.print(str.charAt(0));
            printChars(str.substring(1));
        }
    }

    // 문자열 뒤집어 프린트
    private static void printCharsReverse(String str) {
        if (str.length() == 0)
            return;
        else {
            printCharsReverse(str.substring(1));
            System.out.print(str.charAt(0));
        }
    }

    // 2진수 변환
    private static void printInBinary(int n) {
        if (n < 2)
            System.out.print(n);
        else {
            printInBinary(n / 2);
            System.out.print(n % 2);
        }
    }

    // 배열의 합 구하기
    private static int sum(int n, int[] data) {
        if (n <= 0)
            return 0;
        else
            return sum(n - 1, data) + data[n - 1];
    }

}
