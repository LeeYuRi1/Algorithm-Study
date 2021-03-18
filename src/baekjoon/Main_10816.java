package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_10816 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputN = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] inputM = br.readLine().split(" ");

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(inputN[i]);
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(inputM[i]);
            if (map.containsKey(num)) sb.append(map.get(num) + " ");
            else sb.append(0 + " ");
        }
        System.out.println(sb);
    }
}
