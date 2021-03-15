package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1026 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");
        int[] arrayA = new int[n];
        int[] arrayB = new int[n];
        for (int i = 0; i < n; i++) {
            arrayA[i] = Integer.parseInt(a[i]);
            arrayB[i] = Integer.parseInt(b[i]);
        }
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arrayA[i] * arrayB[n - i - 1];
        }
        System.out.println(sum);
    }
}
