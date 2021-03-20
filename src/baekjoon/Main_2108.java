package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2108 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] p = new int[8001];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            a[i] = input;
            sum += input;
            p[4000 + input]++;
        }
        Arrays.sort(a);

        int freq = 0;
        for (int i = 0; i < p.length; i++) {
            if (freq <= p[i]) freq = p[i];
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < p.length; i++) {
            if (freq == p[i]) list.add(i - 4000);
        }

        if (list.size() == 1) {
            freq = list.get(0);
        } else {
            Collections.sort(list);
            freq = list.get(1);
        }

        //1. 산술평균
        System.out.println((int) Math.round(sum / n));

        //2. 중앙값
        System.out.println(a[a.length / 2]);

        //3. 최빈값
        System.out.println(freq);

        //4. 범위
        System.out.println(a[a.length - 1] - a[0]);
    }
}
