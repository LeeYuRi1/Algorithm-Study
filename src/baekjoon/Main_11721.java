package baekjoon;

import java.util.Scanner;

public class Main_11721 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        for (int i = 0; i < line.length(); i = i + 10) {
            if (line.length() - i < 10) {
                System.out.println(line.substring(i));
            } else {
                System.out.println(line.substring(i, i + 10));
            }
        }
    }
}
