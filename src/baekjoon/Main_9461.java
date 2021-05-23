package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9461 {
    private static int[] num = new int[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(find(n) + "\n");
        }
        System.out.println(sb);
    }

    private static int find(int n) {
        if (n == 0) return 0;
        if (n <= 3) return 1;
        else if (num[n] != 0) return num[n];
        else num[n] = find(n - 2) + find(n - 3);
        return num[n];
    }
}
