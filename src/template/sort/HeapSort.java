package template.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

// 힙정렬
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 8, 2, 4};
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.offer(i);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = pq.poll();
        }
    }
}
