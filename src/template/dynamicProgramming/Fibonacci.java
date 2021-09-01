package template.dynamicProgramming;

public class Fibonacci {
    private static int[] fib = new int[100];

    public static void main(String[] args) {
        int n = 10;
        System.out.println(topDown(n));
        System.out.println(bottomUp(n));
    }

    private static int topDown(int n) {
        if (n <= 2) return 1;
        if (fib[n] != 0) return fib[n];
        fib[n] = topDown(n - 1) + topDown(n - 2);
        return fib[n];
    }

    private static int bottomUp(int n) {
        fib[1] = fib[2] = 1;
        for (int i = 3; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}
