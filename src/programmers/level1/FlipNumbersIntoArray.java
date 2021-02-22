package programmers.level1;

// 자연수 뒤집어 배열로 만들기
public class FlipNumbersIntoArray {
    public static void main(String[] args) {
        System.out.println(solution(12345));
        System.out.println(solution2(12345));
    }

    static public int[] solution(long n) {
        String s = Long.toString(n);
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            answer[i] = s.charAt(s.length() - 1 - i) - '0';
        }
        return answer;
    }

    static public int[] solution2(long n) {
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
