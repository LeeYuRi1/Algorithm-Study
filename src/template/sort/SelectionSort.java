package template.sort;

import java.util.Arrays;

// 선택정렬
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 8, 2, 4};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i; //최솟값을 가진 인덱스
            for (int j = i + 1; j < arr.length; j++) { // 최솟값 탐색
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            if (i != minIndex) swap(arr, minIndex, i); // 최솟값이 자기 자신이 아니라면 바꾸기
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
