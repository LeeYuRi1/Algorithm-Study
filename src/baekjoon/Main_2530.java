package baekjoon;

import java.util.Scanner;

public class Main_2530 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        System.out.print((a + ((b + ((c + d) / 60)) / 60)) % 24 + " ");
        System.out.print((b + ((c + d) / 60)) % 60 + " ");
        System.out.print((c + d) % 60);
    }
}