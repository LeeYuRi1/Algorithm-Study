package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 튜플
public class Solution_64065 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
    }

    public static int[] solution(String s) {
        String[] arr = s.replaceAll("[{}]", "").split(",");
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String i : arr) {
            int n = Integer.parseInt(i);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int[] answer = new int[map.size()];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            answer[map.size() - entry.getValue()] = entry.getKey();
        }
        return answer;
    }
}
