package java_data_structure.chapter1_1;

import java.util.Scanner;

// 중복된 정수쌍을 출력
public class Code11_Duplication {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++)
            data[i] = kb.nextInt();
        kb.close();

        int count = 0;
        //쌍 검사 - 중첩 for문
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) { // 0부터하면 같은 쌍이 두번 카운트 됨. i<j
                if (data[i] == data[j])
                    count++;
            }
        }
        System.out.println(count);

    }
}
