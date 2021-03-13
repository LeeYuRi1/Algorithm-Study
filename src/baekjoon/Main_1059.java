package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1059 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] s = new int[t];
        for (int i = 0; i < t; i++) {
            s[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        Arrays.sort(s);

        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length; i++) {
            if (n == s[i]) {
                System.out.println(0);
                return;
            }
            if (s[i] >= n) {
                if (i != 0) {
                    left = s[i - 1];
                }
                right = s[i];
                break;
            }
        }
        System.out.println((n - left) * (right - n) - 1);
    }
}
