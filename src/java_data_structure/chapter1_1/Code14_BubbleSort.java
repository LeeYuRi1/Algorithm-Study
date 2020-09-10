package java_data_structure.chapter1_1;

import java.util.Scanner;

// n개의 정수를 입력받아 오름차순으로 정렬
// bubble sort: 최대값을 찾아서 맨 마지막으로 보내주는 것을 반복.
// i와 i+1을 비교해서 i가 더 크면 자리를 바꿈
public class Code14_BubbleSort {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = kb.nextInt();
        }
        kb.close();

        //bubble sort
        for (int i = n - 1; i > 0; i--) { //각 스텝마다 비교할 개수가 하나씩 줄음
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    // data[j]와 data[j+1]의 자리를 바꿈
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }

        System.out.println("Sorted data: ");
        for (int i = 0; i < n; i++) {
            System.out.println(data[i]);
        }

    }
}

