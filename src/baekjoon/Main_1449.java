package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int l = Integer.parseInt(input1[1]);
        String[] input2 = br.readLine().split(" ");
        int[] water = new int[n];
        for (int i = 0; i < n; i++) {
            water[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(water);
        int count = 1;
        int start = water[0];
        for (int i = 1; i < n; i++) {
            if (water[i] - start > l - 1) {
                start = water[i];
                count++;
            }
        }
        System.out.println(count);
    }
}
