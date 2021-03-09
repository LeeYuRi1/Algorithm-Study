package baekjoon;

import java.util.HashMap;
import java.util.Scanner;

public class Main_2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int k = 0;
        int max = 0;
        for (int i = 0; i < 3; i++) {
            int n = sc.nextInt();
            if (max < n) max = n;
            if (map.containsKey(n)) {
                k = n;
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        switch (map.size()) {
            case 1:
                System.out.println(10000 + k * 1000);
                break;
            case 2:
                System.out.println(1000 + k * 100);
                break;
            case 3:
                System.out.println(max * 100);
                break;
        }
    }
}
