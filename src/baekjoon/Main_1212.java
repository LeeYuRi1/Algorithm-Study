package baekjoon;

import java.util.Scanner;

public class Main_1212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            if (s.equals("0")) {
                System.out.print(0);
                break;
            }
            int c = s.charAt(i) - '0';
            String tmp = "";
            for (int j = 0; j < 3; j++) {
                int r = c % 2;
                tmp = r + tmp;
                c /= 2;
            }
            if (i == 0) {
                while (tmp.charAt(0) == '0') {
                    tmp = tmp.substring(1);
                }
            }
            System.out.print(tmp);
        }
    }
}
