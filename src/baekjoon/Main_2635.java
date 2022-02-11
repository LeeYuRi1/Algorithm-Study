package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2635 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        String ansStr = "";
        for (int i = 1; i <= n; i++) {
            sb.setLength(0);
            sb.append(n).append(" ").append(i).append(" ");
            int count = getCountRecursion(n, i, 2);
            if (ans < count) {
                ans = count;
                ansStr = sb.toString();
            }
        }
        System.out.println(ans + "\n" + ansStr);
    }

    private static int getCount(int prev1, int prev2) {
        int count = 2;
        while (prev1 >= prev2) {
            count++;
            int num = prev1 - prev2;
            prev1 = prev2;
            prev2 = num;
            sb.append(num).append(" ");
        }
        return count;
    }

    private static int getCountRecursion(int prev1, int prev2, int count) { // 재귀로 풀어보기
        int num = prev1 - prev2;
        if (num < 0) return count;
        sb.append(num).append(" ");
        return getCountRecursion(prev2, num, ++count);
    }
}
