package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Main_15666 {
    private static StringBuilder sb = new StringBuilder();
    private static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(s2[i]);
        }
        Arrays.sort(num);
        int[] arr = new int[m];
        dfs(num, arr, 0, 0, n, m);
        for (String i : set) sb.append(i + "\n");
        System.out.println(sb);
    }

    private static void dfs(int[] num, int[] arr, int j, int depth, int n, int m) {
        if (depth == m) {
            String s = "";
            for (int i : arr) s += i + " ";
            set.add(s);
            return;
        }
        for (int i = j; i < n; i++) {
            arr[depth] = num[i];
            dfs(num, arr, i, depth + 1, n, m);
        }
    }
}
