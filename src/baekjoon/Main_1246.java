package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1246 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] pList = new int[m];
        for (int i = 0; i < m; i++) {
            pList[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(pList);

        int price = 0;
        int max = 0;
        int profit = 0;
        for (int i = 0; i < m; i++) {
            if (m - i < n) {
                profit = pList[i] * (m - i);
            } else {
                profit = pList[i] * n;
            }
            if (profit > max) {
                price = pList[i];
                max = profit;
            }
        }
        System.out.println(price + " " + max);
    }
}
