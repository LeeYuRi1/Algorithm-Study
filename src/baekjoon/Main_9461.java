package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9461 {
    private static long[] num = new long[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        num[1] = 1;
        num[2] = 1;
        num[3] = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(find(n) + "\n");
        }
        System.out.println(sb);
    }

    private static long find(int n) {
        if (num[n] != 0) return num[n];
        else num[n] = find(n - 2) + find(n - 3);
        return num[n];
    }
}
