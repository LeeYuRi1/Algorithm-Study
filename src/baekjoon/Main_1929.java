package baekjoon;

import java.util.Scanner;

//에라토스테네스의 체
public class Main_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean check[] = new boolean[m + 1];
        check[0] = check[1] = true;
        for (int i = 2; i * i <= m; i++) {
            if (!check[i]) {
                for (int j = i + i; j <= m; j += i) {
                    check[j] = true;
                }
            }
        }
        for (int i = n; i <= m; i++) {
            if (check[i] == false) {
                System.out.println(i);
            }
        }
    }
}
