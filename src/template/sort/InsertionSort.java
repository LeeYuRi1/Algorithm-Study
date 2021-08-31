package template.sort;

import java.util.Arrays;

// 삽입정렬
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 8, 2, 4};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i]; // 삽입될 레코드
            int j = i - 1;
            while (j >= 0 && target < arr[j]) { // 타겟이 이전 원소보다 크기 전까지 반복
                arr[j + 1] = arr[j]; // 오른쪽으로 이동
                j--;
            }
            arr[j + 1] = target;
        }
    }
}
