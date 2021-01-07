package baekjoon;

import java.util.Scanner;

public class Main_11022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 1;
        while (n-- > 0) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println("Case #" + x + ": " + a + " + " + b + " = " + (a + b));
            x++;
        }
    }
}
