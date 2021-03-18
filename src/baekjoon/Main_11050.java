package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11050 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        System.out.println(binomialCoefficient(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
    }

    private static int binomialCoefficient(int n, int k) {
        if (k == 0 || k == n) return 1;
        return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }
}
