package programmers;

import java.util.Arrays;
import java.util.HashSet;

// 영어 끝말잇기
public class Solution_12981 {
    private static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (!check(words[i - 1], words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            set.add(words[i]);
        }
        return answer;
    }

    private static boolean check(String pre, String s) {
        return !set.contains(s) && pre.charAt(pre.length() - 1) == s.charAt(0);
    }
}
