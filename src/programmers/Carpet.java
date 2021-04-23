package programmers;

import java.util.Arrays;

public class Carpet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
        System.out.println(Arrays.toString(solution(8, 1)));
        System.out.println(Arrays.toString(solution(24, 24)));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int area = brown + yellow;
        for (int i = 1; i <= area; i++) {
            if (area % i == 0) {
                int j = area / i;
                if ((j * 2) + (i - 2) * 2 == brown) {
                    answer[0] = j;
                    answer[1] = i;
                    break;
                }
            }
        }
        return answer;
    }
}
