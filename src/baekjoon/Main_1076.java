package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_1076 {
    public static void main(String[] args) throws Exception {
        String[] str = new String[]{"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            map.put(str[i], i);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = map.get(br.readLine()) + "";
        String b = map.get(br.readLine()) + "";
        int c = map.get(br.readLine());

        System.out.println((long) (Integer.parseInt(a + b) * Math.pow(10, c)));
    }
}
