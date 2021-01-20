package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<Long, Integer> map = new TreeMap<>();
        while (n-- > 0) {
            Long i = Long.valueOf(br.readLine());
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        Long answer = 0L;
        int valueMax = 0;
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            Long key = entry.getKey();
            Integer value = entry.getValue();
            if (value > valueMax) {
                answer = key;
                valueMax = value;
            }
        }
        System.out.println(answer);
    }
}
