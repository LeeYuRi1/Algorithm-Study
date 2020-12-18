package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            a.add(tmp);
        }
        Collections.sort(a);
        for (int x : a) {
            System.out.println(x);
        }
    }
}
