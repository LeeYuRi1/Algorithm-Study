package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_6603 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] s = br.readLine().split(" ");
            if (s.length == 1) break;
            int[] num = new int[Integer.parseInt(s[0])];
            int[] arr = new int[6];
            for (int i = 1; i < s.length; i++) num[i - 1] = Integer.parseInt(s[i]);
            backtracking(num, arr, 0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void backtracking(int[] num, int[] arr, int depth, int start) {
        if (depth == 6) {
            for (int i : arr) sb.append(i + " ");
            sb.append("\n");
            return;
        }
        for (int i = start; i < num.length; i++) {
            arr[depth] = num[i];
            backtracking(num, arr, depth + 1, i + 1);
        }
    }
}
