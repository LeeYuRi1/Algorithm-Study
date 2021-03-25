package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18870 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        int[] sort = a.clone();
        Arrays.sort(sort);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(sort[i])) map.put(sort[i], num++);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(a[i]) + " ");
        }
        System.out.println(sb);
    }
}
