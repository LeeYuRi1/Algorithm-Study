package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1292 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int[] num = new int[b];
        int index = 0;
        int n = 1;
        while (index < b) {
            for (int j = 0; j < n; j++) {
                if (index == b) {
                    break;
                }
                num[index] = n;
                index++;
            }
            n++;
        }

        int sum = 0;
        for (int i = a - 1; i < b; i++) {
            sum += num[i];
        }
        System.out.println(sum);
    }
}
