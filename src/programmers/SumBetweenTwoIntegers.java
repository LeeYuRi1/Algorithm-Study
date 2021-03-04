package programmers;

// 두 정수 사이의 합
public class SumBetweenTwoIntegers {
    public static void main(String[] args) {
        System.out.println(solution(3, 5));
        System.out.println(solution(5, 3));
    }

    public static long solution(long a, long b) {
        long answer = 0;
        if (a == b) return a;
        if (a > b) {
            long temp = a;
            a = b;
            b = temp;
        }
        answer = ((a + b) * (b - a + 1)) / 2;
        return answer;
    }
}
