package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// 제일 작은 수 제거하기
public class Solution_12935 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 2, 1}));
        System.out.println(solution(new int[]{10}));
    }

    public static int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};
        int[] answer = new int[arr.length - 1];
        List<Integer> a = Arrays.stream(arr).boxed().collect(Collectors.toList());
        a.remove(Collections.min(a));
        for (int i = 0; i < a.size(); i++) {
            answer[i] = a.get(i);
        }
        return answer;
    }
}
