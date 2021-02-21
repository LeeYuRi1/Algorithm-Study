package programmers.level1;

// 문자열을 정수로 바꾸기
public class ConvertStringToInteger {
    public static void main(String[] args) {
        System.out.println(solution("1234"));
        System.out.println(solution("-1234"));

    }

    static public int solution(String s) {
        return Integer.parseInt(s);
    }
}
