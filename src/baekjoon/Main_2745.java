package baekjoon;

import java.util.Scanner;

// Main_11005와 반대로
public class Main_2745 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int b = sc.nextInt();
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                answer = answer * b  + (c-'0');
            } else {
                answer = answer* b + (c - 'A' + 10);
            }
        }
        System.out.println(answer);
    }
}
