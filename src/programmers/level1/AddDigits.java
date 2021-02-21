package programmers.level1;

// 자릿수 더하기
public class AddDigits {
    public static void main(String[] args) {
        System.out.println(solution2(123));
        System.out.println(solution2(987));
    }

    static public int solution(int n) {
        int answer = 0;
        String s = Integer.toString(n);
        for (int i = 0; i < s.length(); i++) {
            answer += s.charAt(i) - '0';
        }
        return answer;
    }

    static public int solution2(int n) {
        int answer = 0;
        while (n > 0) {
            answer += n % 10;
            n /= 10;
        }
        return answer;
    }
}
