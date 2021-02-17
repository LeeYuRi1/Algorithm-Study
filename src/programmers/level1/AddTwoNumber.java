package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

// 두 개 뽑아서 더하기
public class AddTwoNumber {
    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};
        System.out.println(solution(numbers).toString());
    }

    static private ArrayList solution(int[] numbers) {
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
