package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_1094 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(64);
        int sum = 64;
        while (x != sum) {
            sum = 0;
            int min = Collections.min(list);
            list.remove(list.indexOf(min));
            min /= 2;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            if (sum + min >= x) {
                list.add(min);
                sum += min;
            } else {
                list.add(min);
                list.add(min);
                sum += 2 * min;
            }
        }
        System.out.println(list.size());
    }
}
