package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2023 {
    private static int n;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        findNum(0, "");
        System.out.println(sb);
    }

    private static void findNum(int depth, String s) {
        if (depth == n) {
            sb.append(Integer.parseInt(s) + "\n");
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (isPrime(Integer.parseInt(s + i))) findNum(depth + 1, s + i);
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
