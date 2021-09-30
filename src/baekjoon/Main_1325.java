package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1325 {
    private static ArrayList<Integer>[] connectComputer;
    private static boolean[] check;
    private static int[] ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        connectComputer = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            connectComputer[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            connectComputer[a].add(b);
        }

        ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            check = new boolean[n + 1];
            dfs(i);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, ans[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (ans[i] == max) sb.append(i + " ");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int i) {
        check[i] = true;
        for (int j : connectComputer[i]) {
            if (check[j]) continue;
            ans[j]++;
            dfs(j);
        }
    }
}
