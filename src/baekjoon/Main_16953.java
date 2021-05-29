package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_16953 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long a = Long.parseLong(s[0]);
        long b = Long.parseLong(s[1]);
        int ans = 1;
        while (a != b) {
            if (a > b) {
                ans = -1;
                break;
            }
            String stringB = b + "";
            if (b % 2 != 0 && stringB.charAt(stringB.length() - 1) != '1') {
                ans = -1;
                break;
            }
            if (b % 2 == 0) b /= 2;
            else b = Long.parseLong(stringB.substring(0, stringB.length() - 1));
            ans++;
        }
        System.out.println(ans);
    }
}
