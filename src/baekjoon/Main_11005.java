package baekjoon;

import java.util.Scanner;

public class Main_11005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int r = n % b;
            if (r >= 10)
                sb.append((char) (r - 10 + 'A')); // 10부터 A이므로 10을 빼고 아스키코드값 'A'를 더함
            else
                sb.append((char) (r + '0')); // '0'을 더해서 아스키코드로 변환
            n /= b;
        }
        System.out.print(sb.reverse());
    }
}
