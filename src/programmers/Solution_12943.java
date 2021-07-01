package programmers;

// 콜라츠 추측
public class Solution_12943 {
    public static void main(String[] args) {
        System.out.println(solution(6));
        System.out.println(solution(16));
        System.out.println(solution(626331));
    }

    public static int solution(long num) {
        int answer = 0;
        while (num > 1) {
            if (answer == 500) { //500번을 시도해도 1이 되지 못하므로 -1리턴
                return -1;
            }
            // 짝수라면 2로 나누고 홀수라면 3을 곱하고 1을 더함
            num = (num % 2 == 0) ? num / 2 : num * 3 + 1;
            answer++;
        }
        return answer;
    }
}
