package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] budget = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            budget[i] = Integer.parseInt(input[i]);
        }
        int sum = Integer.parseInt(br.readLine());
        Arrays.sort(budget);
        System.out.println(findMaxBudget(budget, sum));
    }

    private static int findMaxBudget(int[] budget, int sum) {
        int min = 0;
        int max = budget[budget.length - 1];
        int mid = 0;
        while (min <= max) {
            mid = (min + max) / 2;
            long result = 0;
            for (int i : budget) {
                if (i >= mid) result += mid;
                else result += i;
            }
            if (result > sum) max = mid - 1;
            else min = mid + 1;
        }
        return max;
    }
}
