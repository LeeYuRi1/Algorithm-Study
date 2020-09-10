package java_data_structure.chapter1_1;

import java.util.Scanner;

public class Code9_Shift {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = kb.nextInt();
        }
        kb.close();

        //shift 연산: 마지막 값을 다른데에 담아두고 맨 마지막을 제외한 값을 전부 뒤로 shift
        int tmp = data[n - 1]; // 배열의 맨마지막 값을 임시변수에 저장
        for (int i = n - 2; i >= 0; i--) {
            data[i + 1] = data[i];
        }
        data[0] = tmp; // 맨뒤에 있던 값을 맨 앞으로 보냄

        for (int i = 0; i < n; i++) {
            System.out.println(data[i]);
        }

    }
}
