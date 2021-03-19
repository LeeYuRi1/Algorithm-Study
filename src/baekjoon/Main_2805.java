package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_2805 {

    private static List<Integer> trees;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        trees = new ArrayList<>();
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            trees.add(Integer.parseInt(input2[i]));
        }
        Collections.sort(trees);
        System.out.println(findHeight(m));
    }

    private static long findHeight(int m) {
        long min = 0;
        long max = trees.get(trees.size() - 1);
        long mid = 0;
        while (min <= max) {
            mid = (min + max) / 2;
            long sum = 0;
            for (int i : trees) {
                if (i > mid) sum += i - mid;
            }
            if (sum >= m) min = mid + 1;
            else max = mid - 1;
        }
        return max;
    }
}
