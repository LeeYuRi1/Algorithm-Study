package algorithm.recursion;

public class Code3_Sum {
    public static void main(String[] args) {
        int result = func(4);
        System.out.println(result);
    }

    // 1~n까지의 합
    private static int func(int n) {
        if (n <= 0)
            return 0;
        else
            return n + func(n - 1);
    }
}