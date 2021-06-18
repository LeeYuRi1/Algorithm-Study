package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main_4358 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> map = new TreeMap<>();
        int sum = 0;
        String s = "";
        while ((s = br.readLine()) != null) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            sum++;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            double d = (double) entry.getValue() * 100 / sum;
            sb.append(entry.getKey() + " " + String.format("%.4f", d) + "\n");
        }
        System.out.println(sb);
    }
}
