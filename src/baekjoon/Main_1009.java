package baekjoon;

import java.util.Scanner;

public class Main_1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int answer = a % 10;
            for (int i = 0; i < b - 1; i++) {
                answer = answer * a % 10;
            }
            if (answer == 0) answer = 10;
            System.out.println(answer);
        }
    }

    private static void solution2() {
        Scanner sc = new Scanner(System.in);
        int[][] d = {{10}, {1}, {2, 4, 8, 6}, {3, 9, 7, 1}, {4, 6}, {5}, {6}, {7, 9, 3, 1}, {8, 4, 2, 6}, {9, 1}};
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(d[a % 10][(b - 1) % d[a % 10].length]);
        }
    }
}
