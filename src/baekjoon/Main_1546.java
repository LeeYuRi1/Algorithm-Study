package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_1546 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        List<Integer> score = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            score.add(Integer.parseInt(input[i]));
        }

        int max = Collections.max(score);
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (double) score.get(i) / max * 100;
        }
        System.out.println(sum / score.size());
    }
}
