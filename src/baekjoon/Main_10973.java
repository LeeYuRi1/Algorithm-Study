package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10973 {
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
        if (prevPermutation()) {
            for (int i : num) sb.append(i + " ");
        } else {
            sb.append(-1);
        }
        System.out.println(sb);
    }

    private static boolean prevPermutation() {
        int i = n - 1, j = n - 1;
        while (i > 0 && num[i - 1] < num[i]) i--;
        if (i <= 0) return false;
        while (num[i - 1] < num[j]) j--;
        swap(i - 1, j);
        j = n - 1;
        while (i < j) {
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
