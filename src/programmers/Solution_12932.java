package programmers;

// 자연수 뒤집어 배열로 만들기
public class Solution_12932 {
    public static void main(String[] args) {
        System.out.println(solution(12345));
        System.out.println(solution2(12345));
    }

    public static int[] solution(long n) {
        String s = Long.toString(n);
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            answer[i] = s.charAt(s.length() - 1 - i) - '0';
        }
        return answer;
    }

    public static int[] solution2(long n) {
        String s = n + "";
        int[] answer = new int[s.length()];
        int i = 0;

        while (n > 0) {
            answer[i] = (int) (n % 10);
            n /= 10;
            i++;
        }
        return answer;
    }
}
