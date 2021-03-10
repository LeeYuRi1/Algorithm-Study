package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main_1157 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            String str = s[i].toUpperCase();
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        int max = Collections.max(map.values());
        String answer = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                if (!answer.equals("")) {
                    answer = "?";
                    break;
                } else {
                    answer = entry.getKey();
                }
            }
        }
        System.out.println(answer);
    }
}
