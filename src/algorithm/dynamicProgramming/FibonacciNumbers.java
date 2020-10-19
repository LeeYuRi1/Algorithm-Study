package algorithm.dynamicProgramming;

// 피보나치수열: 1 1 2 3 5 8 13
// f(n) = f(n-1) + f(n-2)  n > 2, f(1) = f(2) = 1
public class FibonacciNumbers {

    static int[] f = new int[100];

    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib(n));
        System.out.println(fib_memoization(n));
        System.out.println(fib_bottomUp(n));
    }

    private static int fib(int n) { // recursion: 많은 계산이 중복됨. 비효율적
        if (n == 1 || n == 2)
            return 1;
        else
            return fib(n - 2) + fib(n - 1);
    }

    private static int fib_memoization(int n) { // memoization: 중간 계산 결과를 caching함으로써 중복 계산을 피함
        if (n == 1 || n == 2)
            return 1;
        else if (f[n] != 0) // 배열 f가 0로 초기화되어있음. 이미 계산된 값
            return f[n];
        else
            f[n] = fib(n - 2) + fib(n - 1);
        return f[n];
    }

    private static int fib_bottomUp(int n) { // bottom_up 방식(dynamic programming) 배열을 이용해서 순환식의 가장 단순한 항부터 순차적으로 계산
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++)
            f[i] = f[i - 1] + f[i - 2];
        return f[n];
    }

}
