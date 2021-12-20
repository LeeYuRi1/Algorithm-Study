package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int[] len = new int[k];
        for (int i = 0; i < k; i++) {
            len[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(len);
        System.out.println(find(len, n));
    }

    private static long find(int[] len, int n) {
        long min = 1, max = len[len.length - 1], mid;
        while (min <= max) {
            mid = (min + max) / 2;
            long result = 0;
            for (int i : len) result += i / mid;
            if (result < n) max = mid - 1;
            else min = mid + 1;
        }
        return max;
    }
}
