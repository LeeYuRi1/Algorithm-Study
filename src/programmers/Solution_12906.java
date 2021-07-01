package programmers;

import java.util.ArrayList;

// 같은 숫자는 싫어
public class Solution_12906 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        System.out.println(solution(arr));
    }

    public static int[] solution(int[] arr) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != temp.get(temp.size() - 1)) temp.add(arr[i]);
        }

        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        return answer;
    }
}
