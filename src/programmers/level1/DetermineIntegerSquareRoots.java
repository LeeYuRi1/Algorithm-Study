package programmers.level1;

// 정수 제곱근 판별
public class DetermineIntegerSquareRoots {
    public static void main(String[] args) {
        System.out.println(solution(121));
    }

    static public long solution(long n) {
        // n의 제곱근을 구한 뒤, 다시 제곱해서 n과 같으면 제곱근은 정수임
        int m = (int) Math.sqrt(n);
        if (Math.pow(m, 2) == n) return (long) Math.pow(m + 1, 2);
        return -1;
    }
}
