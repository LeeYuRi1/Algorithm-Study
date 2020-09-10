package java_data_structure.chapter1_1;

import java.util.Scanner;

// n개의 정수를 입력받는데 정수가 하나씩 입력될 때마다 오름차순으로 정렬
// ordered list에 새로운 값을 insert하는 알고리즘
public class Code15_OrderedSort {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            int tmp = kb.nextInt();

            int j = i - 1; // 뒤에서부터 시작(데이터를 반만 검사해도 되기 때문)
            while (j >= 0 && data[j] > tmp) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = tmp;

            for (int k = 0; k <= i; k++)
                System.out.print(data[k] + " ");
            System.out.println();
        }
        kb.close();
    }
}