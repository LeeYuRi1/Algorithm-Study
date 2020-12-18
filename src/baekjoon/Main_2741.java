package baekjoon;

import java.util.Scanner;

public class Main_2741 {
    // 시간: 1516 ms
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    // StringBuilder 사용: 출력해야 하는 것이 많은 경우 사용
    // 시간: 264 ms
    public static void answer() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i + "\n");
        }
        System.out.print(sb);
    }
}
