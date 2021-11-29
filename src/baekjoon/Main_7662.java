package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main_7662 {
    private static TreeMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            map = new TreeMap<>();
            while (k-- > 0) {
                String[] input = br.readLine().split(" ");
                operation(input[0], Integer.parseInt(input[1]));
            }
            if (map.isEmpty()) sb.append("EMPTY\n");
            else sb.append(map.lastKey() + " " + map.firstKey() + "\n");
        }
        System.out.println(sb);
    }

    private static void operation(String op, int n) {
        if (op.equals("I")) { // 삽입
            map.put(n, map.getOrDefault(n, 0) + 1);
        } else { // 삭제
            if (map.isEmpty()) return;
            int k = n == 1 ? map.lastKey() : map.firstKey(); // 1: 최댓값 삭제, -1: 최솟값 삭제
            map.put(k, map.get(k) - 1);
            if (map.get(k) == 0) map.remove(k);
        }
    }
}
