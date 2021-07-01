package programmers;

// 문자열 다루기 기본
public class Solution_12918 {
    public static void main(String[] args) {
        System.out.println(solution("a234"));
        System.out.println(solution("1234"));
    }

    public static boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 48 || c > 57) return false;
        }
        return true;
    }
}
