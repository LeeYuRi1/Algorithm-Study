package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k < coin[i]) continue;
            if (k == 0) break;
            ans += k / coin[i];
            k %= coin[i];
        }
        System.out.println(ans);
    }
}