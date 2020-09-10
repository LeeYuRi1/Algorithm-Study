package java_data_structure.chapter1_2;

import java.util.Scanner;

public class Code18_BubbleSort_Exception {
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
                    swap(data[j], data[j + 1]); // 변경되지 않아서 입력한 그대로 출력
                }
            }
        }
    }

    // 값에 의한 호출
    // data[j], data[j+1]와 a, b는 별개의 변수 - 호출되는 순간 복사된 것: a,b 값을 변경해도 data[j], data[j+1]의 값에는 변화 없음
    // bubbleSort에서 배열을 매개변수로 넘기면 원본배열에도 반영: 프리미티브 타입이 아니기 때문
    static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    // 참조에 의한 호출 - c, java 에서는 지원하지 않음
}