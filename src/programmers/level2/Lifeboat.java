package programmers.level2;

import java.util.Arrays;

// 구명보트
public class Lifeboat {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 80, 50}, 100));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int first = 0;
        int last = people.length - 1;
        while (first <= last) {
            if (people[first] + people[last] <= limit) first++;
            last--;
            answer++;
        }
        return answer;
    }
}
