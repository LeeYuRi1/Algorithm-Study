package programmers;

import java.util.Arrays;

// 문자열 내림차순으로 배치하기
public class StringDescending {
    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }

    public static String solution(String s) {
        String answer = "";
        String[] a = s.split("");
        Arrays.sort(a);
        for (String i : a) {
            answer = i.concat(answer);
        }
        return answer;
    }
}
