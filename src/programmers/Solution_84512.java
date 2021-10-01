package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 모음사전
public class Solution_84512 {
    private static List<String> words = new ArrayList<>();
    private static int[] arr;
    private static char[] letter = {'A', 'E', 'I', 'O', 'U'};

    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
        System.out.println(solution("AAAE"));
        System.out.println(solution("I"));
        System.out.println(solution("EIO"));
    }

    public static int solution(String word) {
        for (int i = 1; i <= 5; i++) {
            arr = new int[i];
            makeWords(0, i);
        }
        Collections.sort(words);
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(word)) return i + 1;
        }
        return -1;
    }

    private static void makeWords(int depth, int n) {
        if (depth == n) {
            String s = "";
            for (int i : arr) s += letter[i];
            words.add(s);
            return;
        }
        for (int i = 0; i < 5; i++) {
            arr[depth] = i;
            makeWords(depth + 1, n);
        }
    }
}
