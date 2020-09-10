package java_data_structure.chapter1_2;

import java.util.Scanner;

// 두 정수 a와 b(음이 아닌 정수)를 입력 받아 a의 b승을 계산
public class Code16_Power {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        int b = kb.nextInt();

        int result = power(a, b);

        System.out.println(result);
        kb.close();
    }

    static int power(int n, int m) {
        int prod = 1;
        for (int i = 0; i < m; i++)  //m번 반복
            prod = prod * n;
        return prod;
    }
}