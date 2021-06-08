package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_14719 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        int w = Integer.parseInt(s1[1]);
        int[] block = new int[w];
        for (int i = 0; i < w; i++) {
            block[i] = Integer.parseInt(s2[i]);
        }

        int ans = 0;
        for (int i = 1; i < w - 1; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < i; j++) {
                if (block[j] > left) left = block[j];
            }
            for (int j = i + 1; j < w; j++) {
                if (block[j] > right) right = block[j];
            }
            int t = Math.min(left, right) - block[i];
            if (t > 0) ans += t;
        }
        System.out.println(ans);
    }
}
