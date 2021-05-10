package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2484 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        while (n-- > 0) {
            int[] num = new int[7];
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < 4; i++) {
                num[Integer.parseInt(input[i])]++;
            }
            ans = Math.max(ans, prizeMoney(num));
        }
        System.out.println(ans);
    }

    private static int prizeMoney(int[] num) {
        int ans = 0;
        for (int i = 1; i <= 6; i++) {
            int result = 0;
            if (num[i] == 4) {
                result = 50000 + i * 5000;
            } else if (num[i] == 3) {
                result = 10000 + i * 1000;
            } else if (num[i] == 2) {
                for (int j = i + 1; j <= 6; j++) {
                    if (num[j] == 2) result += j * 500;
                }
                if (result != 0) result += 2000 + i * 500;
                else result = 1000 + i * 100;
            } else if (num[i] == 1) {
                result = i * 100;
            }
            ans = Math.max(ans, result);
        }
        return ans;
    }
}