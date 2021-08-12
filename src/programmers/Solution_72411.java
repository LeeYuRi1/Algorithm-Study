package programmers;

import java.util.*;

// 메뉴 리뉴얼
public class Solution_72411 {
    private static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
    }

    public static String[] solution(String[] orders, int[] course) {
        // 조합 찾기
        for (int i = 0; i < orders.length; i++) {
            String[] s = orders[i].split("");
            Arrays.sort(s);
            for (int j = 0; j < course.length; j++) {
                String[] arr = new String[course[j]];
                backtracking(arr, s, 0, course[j], 0);
            }
        }

        // 최대값 찾기
        int[] max = new int[course[course.length - 1] + 1];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int len = entry.getKey().length();
            max[len] = Math.max(max[len], entry.getValue());
        }

        // 최대값인 조합 찾기
        ArrayList<String> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int len = entry.getKey().length();
            if (max[len] < 2) continue;
            if (max[len] == entry.getValue()) answer.add(entry.getKey());
        }
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }

    private static void backtracking(String[] arr, String[] s, int depth, int n, int start) {
        if (depth == n) {
            String result = "";
            for (String i : arr) result += i;
            map.put(result, map.getOrDefault(result, 0) + 1);
            return;
        }
        for (int i = start; i < s.length; i++) {
            arr[depth] = s[i];
            backtracking(arr, s, depth + 1, n, i + 1);
        }
    }
}
