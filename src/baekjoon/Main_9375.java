package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_9375 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            while (n-- > 0) {
                String[] s = br.readLine().split(" ");
                map.put(s[1], map.getOrDefault(s[1], 0) + 1);
            }
            int ans = 1;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                ans *= entry.getValue() + 1;
            }
            sb.append(ans - 1 + "\n");
        }
        System.out.println(sb);
    }
}
