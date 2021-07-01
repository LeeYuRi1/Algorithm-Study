package programmers;

import java.util.LinkedHashMap;

// 기능개발
public class Solution_42586 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
        System.out.println(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < progresses.length; i++) {
            days[i] = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) days[i]++;
        }

        int n = 0;
        int d = 0;
        for (int i = 0; i < days.length; i++) {
            if (i == 0) {
                d = days[i];
                map.put(n, 1);
            } else if (d >= days[i]) {
                map.put(n, map.get(n) + 1);
            } else {
                d = days[i];
                n++;
                map.put(n, 1);
            }
        }

        int[] answer = new int[map.size()];
        for (int i = 0; i < map.size(); i++) {
            answer[i] = map.get(i);
        }
        return answer;
    }
}
