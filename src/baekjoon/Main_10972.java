package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 다음 순열 구하기
// 1. A[i-1] < A[i]를 만족하는 가장 큰 i를 찾음
// 2, j >= i 이면서 A[j] > A[i-1]를 만족하는 가장 큰 j를 찾음
// 3. A[i-1]과 A[j]를 swap
// 4. A[i]부터 순열을 뒤집음
public class Main_10972 {
    private static int n;
    private static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(input[i]);
        }
        StringBuilder sb = new StringBuilder();
        if (nextPermutation()) {
            for (int i : num) sb.append(i + " ");
        } else {
            sb.append(-1);
        }
        System.out.println(sb);
    }

    private static boolean nextPermutation() {
        int i = n - 1, j = n - 1;
        while (i > 0 && num[i - 1] >= num[i]) i--; // 1
        if (i <= 0) return false; // 마지막 순열
        while (num[i - 1] >= num[j]) j--; // 2
        swap(i - 1, j); // 3
        j = n - 1;
        while (i < j) { // 4
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }

    private static void swap(int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
