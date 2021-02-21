package programmers.level1;

// 약수의 합
public class SumOfDivisor {
    public static void main(String[] args) {
        System.out.println(solution(12));
        System.out.println(solution(5));
    }

    static public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        return answer + n;
    }
}
