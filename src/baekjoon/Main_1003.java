package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            int[][] count = new int[n + 1][2];
            if (n == 0) {
                sb.append("1 0");
            } else if (n == 1) {
                sb.append("0 1");
            } else {
                count[0][0] = 1;
                count[1][1] = 1;
                for (int i = 2; i <= n; i++) {
                    count[i][0] = count[i - 1][0] + count[i - 2][0];
                    count[i][1] = count[i - 1][1] + count[i - 2][1];
                }
                sb.append(count[n][0] + " " + count[n][1]);
            }
            System.out.println(sb);
        }
    }
}
