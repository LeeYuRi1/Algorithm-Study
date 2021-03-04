package programmers;

// x만큼 간격이 있는 n개의 숫자
public class NNumbersSpacedByX {
    public static void main(String[] args) {
        System.out.println(solution(2, 5));
        System.out.println(solution(4, 3));
        System.out.println(solution(-4, 2));
    }

    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (long i = 0; i < n; i++) {
            answer[(int) i] = x * (i + 1);
        }
        return answer;
    }
}
