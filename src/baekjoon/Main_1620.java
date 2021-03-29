package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_1620 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Map<Integer, String> mapInt = new HashMap<>();
        Map<String, Integer> mapString = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            mapInt.put(i, s);
            mapString.put(s, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            String result = "";
            if (mapString.containsKey(s)) {
                result = mapString.get(s) + "";
            } else {
                result = mapInt.get(Integer.parseInt(s));
            }
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}
