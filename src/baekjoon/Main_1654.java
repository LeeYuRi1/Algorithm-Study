package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_1654 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        System.out.println(find(list, list.get(list.size() - 1), n));
    }

    private static long find(List<Integer> list, int l, int n) {
        long min = 1;
        long max = l;
        long mid = 0;
        while (min <= max) {
            mid = (min + max) / 2;
            long count = 0;
            for (int i = 0; i < list.size(); i++) {
                count += list.get(i)/mid;
            }
            if (count >= n) min = mid + 1;
            else max = mid - 1;
        }
        return max;
    }
}
