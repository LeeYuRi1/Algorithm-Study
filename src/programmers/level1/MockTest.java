package programmers.level1;

import java.util.*;

// 모의고사
public class MockTest {
    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
        System.out.println(solution(answers));
    }

    static public ArrayList solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();

        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i % 5]) {
                map.put(1, map.get(1) + 1);
            }
            if (answers[i] == student2[i % 8]) {
                map.put(2, map.get(2) + 1);
            }
            if (answers[i] == student3[i % 10]) {
                map.put(3, map.get(3) + 1);
            }
        }

        ArrayList<Integer> values = new ArrayList<>(map.values());
        int max = Collections.max(values);
        for (int i = 1; i <= 3; i++) {
            if (map.get(i) == max) answer.add(i);
        }
        return answer;
    }
}
