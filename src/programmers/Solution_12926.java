package programmers;

// 시저 암호
public class Solution_12926 {
    public static void main(String[] args) {
        System.out.println(solution("AB", 1));
        System.out.println(solution("z", 1));
        System.out.println(solution("a B z", 4));
    }

    public static String solution(String s, int n) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i);
            if (value != ' ') {
                if (value < 'a') { //대문자일때
                    value = value - 'A';
                    answer += (char) ((value + n) % 26 + 'A');
                } else { //소문자일때
                    value = value - 'a';
                    answer += (char) ((value + n) % 26 + 'a');
                }
            } else {
                answer += " ";
            }
        }
        return answer;
    }
}
