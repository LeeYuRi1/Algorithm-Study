package baekjoon;

import java.util.Scanner;

public class Main_2420 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long answer = (n > m) ? n - m : m - n;
        System.out.println(answer);
    }
}
