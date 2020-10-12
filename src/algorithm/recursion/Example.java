package algorithm.recursion;

public class Example {
    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println(power(3, 2));
        System.out.println(fibonacci(5));
        System.out.println(gcd(6, 4));
    }

    private static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }

    private static double power(double x, int n) {
        if (n == 0)
            return 1;
        else
            return x * power(x, n - 1);
    }

    private static int fibonacci(int n) {
        if (n < 2)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static int gcd(int m, int n) {
        if (n == 0)
            return m;
        else
            return gcd(n, m % n);
    }


}
