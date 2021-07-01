package programmers;

import java.util.ArrayList;
import java.util.Arrays;

// 나누어 떨어지는 숫자 배열
public class Solution_12910 {
    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 10};
        System.out.println(solution(arr, 5));
    }

    public static int[] solution(int[] arr, int divisor) {
        int[] answer = {-1};
        Arrays.sort(arr);
        if (divisor == 1) return arr;

        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) temp.add(arr[i]);
        }

        if (temp.size() == 0) return answer;
        answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        return answer;
    }
}
