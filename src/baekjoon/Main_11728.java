package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        String[] inputA = br.readLine().split(" ");
        String[] inputB = br.readLine().split(" ");

        int[] num = new int[n + m];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(inputA[i]);
        }
        for (int i = 0; i < m; i++) {
            num[i + n] = Integer.parseInt(inputB[i]);
        }
        Arrays.sort(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n + m; i++) {
            sb.append(num[i] + " ");
        }
        System.out.println(sb);
    }
}
