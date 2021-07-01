package programmers;

import java.util.ArrayList;
import java.util.Collections;

// 두 개 뽑아서 더하기
public class Solution_68644 {
    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};
        System.out.println(solution(numbers).toString());
    }

    // 두 수를 뽑아서 더한 값이 존재하지 않으면 추가하고 정렬
    public static ArrayList solution(int[] numbers) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (!a.contains(numbers[i] + numbers[j])) {
                    a.add(numbers[i] + numbers[j]);
                }
            }
        }
        Collections.sort(a);
        return a;
    }
}
