package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] inputN = br.readLine().split(" ");
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(inputN[i]);
            a[i] = sum;
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String[] inputM = br.readLine().split(" ");
            int i = Integer.parseInt(inputM[0]) - 2;
            int j = Integer.parseInt(inputM[1]) - 1;
            if (i == -1) {
                sb.append(a[j] + "\n");
            } else {
                sb.append(a[j] - a[i] + "\n");
            }
        }
        System.out.println(sb);
    }
}
