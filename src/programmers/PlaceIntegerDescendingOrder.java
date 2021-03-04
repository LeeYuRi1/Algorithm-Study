package programmers;

import java.util.Arrays;
import java.util.Collections;

// 정수 내림차순으로 배치하기
public class PlaceIntegerDescendingOrder {
    public static void main(String[] args) {
        System.out.println(solution(118372));
    }

    public static long solution(long n) {
        String answer = "";
        String[] s = Long.toString(n).split("");
        Arrays.sort(s, Collections.reverseOrder());
        for (String i : s) {
            answer += i;
        }
        return Long.valueOf(answer);
    }
}
