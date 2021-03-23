package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SumWithMultiplicity {
    public static void main(String[] args) {
        System.out.println(threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
        System.out.println(threeSumMulti(new int[]{1, 1, 2, 2, 2, 2}, 5));
    }

    public static int threeSumMulti(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            answer = (answer + map.getOrDefault(target - arr[i], 0)) % 1000000007;
            for (int j = 0; j < i; j++) {
                int t = arr[i] + arr[j];
                map.put(t, map.getOrDefault(t, 0) + 1);
            }
        }
        return answer;
    }
}
