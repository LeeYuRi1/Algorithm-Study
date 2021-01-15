package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_6588 {
    public static final int MAX = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean check[] = new boolean[MAX + 1]; //true: 지워진 것(소수가 아님), false: 지워지지 않음(소수)
        ArrayList<Integer> prime = new ArrayList<>();

        //에라토스테네스의 체
        check[0] = check[1] = true;
        for (int i = 2; i * i <= MAX; i++) {
            if (!check[i]) {
                prime.add(i);
                for (int j = i + i; j <= MAX; j += i) {
                    check[j] = true;
                }
            }
        }

        while (true) {
            boolean b = false;
            int n = sc.nextInt();
            if (n == 0) break;
            for (int i = 1; i < prime.size(); i++) {
                int p = prime.get(i);
                if (!check[n - p]) {
                    System.out.println(n + " = " + p + " + " + (n - p));
                    b = true;
                    break;
                }
            }
            if (!b) System.out.println("Goldbach's conjecture is wrong.");
        }
    }
}
