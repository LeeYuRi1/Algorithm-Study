package programmers;

// 소수 찾기 (level 1)
public class FindPrimeNumbers1 {
    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    public static int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i && isPrime; j++) {
                if (i % j == 0) isPrime = false;
            }
            if (isPrime) answer++;
        }
        return answer;
    }
}
