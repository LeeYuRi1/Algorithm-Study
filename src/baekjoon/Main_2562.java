package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_2562 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            num.add(Integer.parseInt(br.readLine()));
        }
        int max = Collections.max(num);
        System.out.println(max);
        System.out.println(num.indexOf(max) + 1);
    }
}
