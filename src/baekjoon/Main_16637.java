package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16637 {
    private static int N, ans = Integer.MIN_VALUE, num[];
    private static char[] oper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");
        num = new int[N / 2 + 1];
        oper = new char[N / 2];
        for (int i = 0, j = 0; i < N; i++) {
            if (i % 2 == 0) num[j] = Integer.parseInt(input[i]);
            else oper[j++] = input[i].charAt(0);
        }
        dfs(0, num[0]);
        System.out.println(ans);
    }

    private static void dfs(int cnt, int result) {
        if (cnt == N / 2) {
            ans = Math.max(ans, result);
            return;
        }
        dfs(cnt + 1, cal(result, num[cnt + 1], oper[cnt]));
        if (cnt + 2 <= N / 2) {
            int temp = cal(num[cnt + 1], num[cnt + 2], oper[cnt + 1]);
            dfs(cnt + 2, cal(result, temp, oper[cnt]));
        }
    }

    private static int cal(int a, int b, int op) {
        if (op == '+') return a + b;
        else if (op == '-') return a - b;
        else return a * b;
    }
}
