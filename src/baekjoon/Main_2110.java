package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2110 {
    private static int[] house;
    private static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        c = Integer.parseInt(input1[1]);
        house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);
        System.out.println(find());
    }

    // 가장 인접한 두 공유기 사이의 거리
    // 커질수록 공유기의 개수 작아짐
    private static long find() {
        long min = 1, max = house[house.length - 1] - house[0], mid;
        while (min <= max) {
            mid = (min + max) / 2;
            if (check(mid)) min = mid + 1; // 공유기 개수가 c보다 같거나 크면 공유기 사이의 거리를 크게 만들어줌
            else max = mid - 1;
        }
        return max;
    }

    private static boolean check(long mid) {
        int count = 1;
        int pre = house[0];
        for (int i : house) {
            if (i - pre < mid) continue;
            pre = i;
            count++;
        }
        return count >= c;
    }
}
