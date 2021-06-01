package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_14888 {
    private static int max = -1000000001;
    private static int min = 1000000001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");

        int[] num = new int[n];
        int[] operator = new int[n - 1];
        int[] result = new int[n - 1];
        boolean[] visit = new boolean[n - 1];
        int index = 0;

        for (int i = 0; i < n; i++) num[i] = Integer.parseInt(s1[i]);
        for (int i = 0; i < 4; i++) {
            int m = Integer.parseInt(s2[i]);
            while (m-- > 0) {
                operator[index] = i;
                index++;
            }
        }
        dfs(num, operator, result, visit, 0, n);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int[] num, int[] operator, int[] result, boolean[] visit, int index, int n) {
        if (index == n - 1) {
            calculate(num, result);
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[index] = operator[i];
                dfs(num, operator, result, visit, index + 1, n);
                visit[i] = false;
            }
        }
    }

    private static void calculate(int[] num, int[] result) {
        int ans = num[0];
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) ans += num[i + 1];
            else if (result[i] == 1) ans -= num[i + 1];
            else if (result[i] == 2) ans *= num[i + 1];
            else ans /= num[i + 1];
        }
        if (ans > max) max = ans;
        if (ans < min) min = ans;
    }
}
