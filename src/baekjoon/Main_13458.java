package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        int b = Integer.parseInt(input2[0]);
        int c = Integer.parseInt(input2[1]);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int candidate = Integer.parseInt(input1[i]) - b;
            ans++;
            if (candidate > 0) {
                ans += candidate / c;
                if (candidate % c != 0) ans++;
            }
        }
        System.out.println(ans);
    }
}
