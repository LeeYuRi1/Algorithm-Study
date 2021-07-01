package programmers;

// 하샤드 수
// x의 각 자릿수의 합으로 x가 나누어지는 양의 정수
public class Solution_12947 {
    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(12));
        System.out.println(solution(11));
        System.out.println(solution(13));
    }

    public static boolean solution(int x) {
        int sum = 0;
        int n = x;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return x % sum == 0;
    }
}
