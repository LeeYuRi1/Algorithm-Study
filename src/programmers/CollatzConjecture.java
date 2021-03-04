package programmers;

// 콜라츠 추측
public class CollatzConjecture {
    public static void main(String[] args) {
        System.out.println(solution(6));
        System.out.println(solution(16));
        System.out.println(solution(626331));
    }

    public static int solution(long num) {
        int answer = 0;
        while (num > 1) {
            if (answer == 500) {
                return -1;
            }
            num = (num % 2 == 0) ? num / 2 : num * 3 + 1;
            answer++;
        }
        return answer;
    }
}
