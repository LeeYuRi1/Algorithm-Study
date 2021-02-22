package programmers.level1;

// 하샤드 수
public class AllHarshadNumber {
    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(12));
        System.out.println(solution(11));
        System.out.println(solution(13));
    }

    static public boolean solution(int x) {
        int sum = 0;
        int n = x;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return x % sum == 0;
    }
}
