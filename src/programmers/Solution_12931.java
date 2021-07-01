package programmers;

// 자릿수 더하기
public class Solution_12931 {
    public static void main(String[] args) {
        System.out.println(solution2(123));
        System.out.println(solution2(987));
    }

    // 문자열을 변환하는 방식
    public static int solution(int n) {
        int answer = 0;
        String s = Integer.toString(n);
        for (int i = 0; i < s.length(); i++) {
            answer += s.charAt(i) - '0';
        }
        return answer;
    }

    // 10으로 나누는 방식
    public static int solution2(int n) {
        int answer = 0;
        while (n > 0) {
            answer += n % 10; // 일의자리수를 구해서 더함
            n /= 10;
        }
        return answer;
    }
}
