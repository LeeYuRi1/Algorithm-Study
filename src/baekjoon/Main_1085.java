package baekjoon;

import java.util.Scanner;

public class Main_1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int a = Math.min(w - x, x);
        int b = Math.min(h - y, y);
        System.out.println(Math.min(a, b));
    }
}
