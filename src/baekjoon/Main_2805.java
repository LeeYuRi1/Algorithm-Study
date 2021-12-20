package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        int[] len = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(len);
        System.out.println(find(len, m));
    }

    private static long find(int[] len, int m) {
        long min = 0, max = len[len.length - 1], mid;
        while (min <= max) {
            mid = (min + max) / 2;
            long result = 0;
            for (int i : len) {
                if (i > mid) result += i - mid;
            }
            if (result < m) max = mid - 1;
            else min = mid + 1;
        }
        return max;
    }
}
