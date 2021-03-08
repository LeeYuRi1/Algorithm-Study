package baekjoon;

import java.util.Scanner;

public class Main_6749 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int young = sc.nextInt();
        int middle = sc.nextInt();
        System.out.println(middle + (middle - young));
    }
}
