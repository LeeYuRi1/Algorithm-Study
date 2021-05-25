package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1561 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        String[] input2 = br.readLine().split(" ");
        int[] num = new int[m];
        for (int i = 0; i < m; i++) {
            num[i] = Integer.parseInt(input2[i]);
        }
        if (n <= m) {
            System.out.println(n);
        } else {
            long time = binarySearch(num, n - m);
            long child = m;
            for (int i : num) child += (time - 1) / i;
            for (int i = 0; i < m; i++) {
                if (time % num[i] == 0) {
                    child++;
                    if (child == n) {
                        System.out.println(i + 1);
                        break;
                    }
                }
            }
        }
    }

    private static long binarySearch(int[] num, int n) {
        long min = 1;
        long max = 2000000000L * 10000L;
        long ans = 0;
        while (min <= max) {
            long mid = (min + max) / 2;
            long count = 0;
            for (int i : num) {
                count += mid / i;
            }
            if (n <= count) {
                ans = mid;
                max = mid - 1;
            } else min = mid + 1;
        }
        return ans;
    }
}
