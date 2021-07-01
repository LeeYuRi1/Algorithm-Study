package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 가장 큰 수
public class Solution_42746 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
        System.out.println(solution(new int[]{0, 0, 0, 0}));
    }

    public static String solution(int[] numbers) {
        String answer = "";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i] + "");
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2);
            }
        });
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i);
        }
        if (answer.charAt(0) - '0' == 0) return "0";
        else return answer;
    }
}
