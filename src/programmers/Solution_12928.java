package programmers;

// 약수의 합
public class Solution_12928 {
    public static void main(String[] args) {
        System.out.println(solution(12));
        System.out.println(solution(5));
    }

    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n / 2; i++) { // 가장 큰 약수는 n/2
            if (n % i == 0) {
                answer += i;
            }
        }
        return answer + n;
    }
}
