package java_data_structure.chapter1_2;

import java.util.Scanner;

// Code14 함수 분할: n개의 정수를 입력받아 오름차순으로 정렬
public class Code18_BubbleSort {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = kb.nextInt();
        }
        kb.close();

        bubbleSort(n, data);

        System.out.println("Sorted data: ");
        for (int i = 0; i < n; i++) {
            System.out.println(data[i]);
        }
    }

    static void bubbleSort(int n, int[] data) {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }
}