package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_4153 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] input = br.readLine().split(" ");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int num = Integer.parseInt(input[i]);
                if (num == 0) return;
                list.add(num * num);
            }
            Collections.sort(list);
            String result = "";
            if (list.get(0) + list.get(1) == list.get(2)) result = "right";
            else result = "wrong";
            System.out.println(result);
        }
    }
}
