package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_2110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        System.out.println(find(list, c));
    }

    private static int find(List<Integer> list, int c) {
        int min = 1;
        int max = list.get(list.size() - 1) - list.get(0);
        int mid = 0;
        while (min <= max) {
            mid = (min + max) / 2;
            if (check(list, mid, c)) min = mid + 1;
            else max = mid - 1;
        }
        return max;
    }

    private static boolean check(List<Integer> list, int mid, int c) { // mid: 가장 인접한 거리
        int count = 1; // 공유기 설치 개수
        int end = list.get(0);
        for (int i : list) {
            if (i - end >= mid) {
                count++;
                end = i;
            }
        }
        return count >= c;
    }
}
