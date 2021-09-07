package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long x = Long.parseLong(input[0]);
        long y = Long.parseLong(input[1]);
        long z = y * 100 / x;
        if (z >= 99) System.out.println(-1);
        else System.out.println(findMin(x, y, z));
    }

    private static long findMin(long x, long y, long z) {
        long min = 0;
        long max = 1000000000;
        long mid = 0;
        while (min <= max) {
            mid = (min + max) / 2;
            long nz = (y + mid) * 100 / (x + mid);
            if (nz > z) max = mid - 1;
            else min = mid + 1;
        }
        return min;
    }
}
