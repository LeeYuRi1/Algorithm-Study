package programmers.level1;

// 3진법 뒤집기
public class TernaryReverse {
    public static void main(String[] args) {
        System.out.println(solution(45));
    }

    static public int solution(int n) {
        int answer = 0;
        String num3 = "";
        while (n > 0) {
            int r = n % 3;
            num3 += r;
            n /= 3;
        }

        for (int i = 0; i < num3.length(); i++) {
            answer = answer * 3 + (num3.charAt(i) - '0');
        }

        return answer;
    }
}
