package baekjoon;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main_10827 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigDecimal a = sc.nextBigDecimal();
        int b = sc.nextInt();

        System.out.println((a.pow(b)).toPlainString()); // 정확한 실수값 출력
    }
}
