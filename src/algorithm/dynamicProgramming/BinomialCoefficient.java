package algorithm.dynamicProgramming;

// 이항 계수(nCk): n개 중에서 k개를 선택하는 경우의 수
public class BinomialCoefficient {

    static int[][] binom = new int[100][100];

    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        System.out.println(binomial(n, k));
        System.out.println(binomial_memoization(n, k));
        System.out.println(binomial_bottomUp(n, k));
    }

    private static int binomial(int n, int k) { // recursion
        if (n == k || k == 0)
            return 1;
        else
            return binomial(n - 1, k) + binomial(n - 1, k - 1);
    }

    private static int binomial_memoization(int n, int k) {
        if (n == k || k == 0)
            return 1;
        else if (binom[n][k] != 0)
            return binom[n][k];
        else {
            binom[n][k] = binomial(n - 1, k) + binomial(n - 1, k - 1);
            return binom[n][k];
        }
    }

    private static int binomial_bottomUp(int n, int k) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k && j <= i; j++) {
                if (j == 0 || i == j)
                    binom[i][j] = 1;
                else
                    binom[i][j] = binom[i - 1][j - 1] + binom[i - 1][j]; // 오른쪽이 왼쪽보다 먼저 계산
            }
        }
        return binom[n][k];
    }
}
