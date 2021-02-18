package programmers.level1;

// 가운데 글자 가져오기
public class GetMiddleLetter {
    public static void main(String[] args) {
        System.out.println(solution("abcde"));
        System.out.println(solution("qwer"));
    }

    static public String solution(String s) {
        String answer = "";
        if (s.length() % 2 == 0) {
            answer += s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        } else {
            answer += s.charAt(s.length() / 2);
        }
        return answer;
    }
}
