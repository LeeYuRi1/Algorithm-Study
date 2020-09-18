package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_6588 {
    public static final int MAX = 1000000;
    static boolean[] isPrime = new boolean[MAX + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> num = new ArrayList<>();
        boolean flag = false;
        primeList();

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            num.add(n);
        }

        for (int n = 0; n < num.size(); n++) {
            flag = false;
            for (int m = 3; m <= num.get(n) / 2; m += 2)
                if (!isPrime[m] && !isPrime[num.get(n) - m]) {
                    System.out.println(num.get(n) + " = " + m + " + " + (num.get(n) - m));
                    flag = true;
                    break;
                }
            if (!flag) System.out.println("Goldbach's conjecture is wrong.");
        }
    }

    // 에라토스테네스의 체
    private static void primeList() {
        isPrime[0] = true;
        isPrime[1] = true;
        for (int i = 2; i * i < MAX; i++)
            if (!isPrime[i])
                for (int j = i + i; j <= MAX; j += i)
                    isPrime[j] = true;
    }

}
