package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_4796 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = 0;
        while (true) {
            String[] s = br.readLine().split(" ");
            int l = Integer.parseInt(s[0]);
            int p = Integer.parseInt(s[1]);
            int v = Integer.parseInt(s[2]);
            if (l + p + v == 0) break;
            int ans = (v / p) * l;
            if (v % p != 0) ans += Math.min(v % p, l);
            sb.append("Case " + ++n + ": " + ans + "\n");
        }
        System.out.println(sb);
    }
}
