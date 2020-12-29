package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        HashMap<String, Integer> map = new HashMap<>();

        //듣도 못한 사람에게 +1, 보도 못한 사람에게 +2
        for (int i = 0; i < n; i++) {
            String name = bf.readLine();
            map.put(name, 1);
        }
        for (int i = 0; i < m; i++) {
            String name = bf.readLine();
            Integer v = map.get(name);
            if (v == null) {
                v = 0;
            }
            v += 2;
            map.put(name, v);
        }

        ArrayList<String> list = new ArrayList<String>();
        // map에 들어있는 값 순회
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 3) {
                list.add(key);
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (String name: list) {
            System.out.println(name);
        }

    }
}
