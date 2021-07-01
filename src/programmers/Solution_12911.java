package programmers;

// 다음 큰 숫자
public class Solution_12911 {
    public static void main(String[] args) {
        System.out.println(solution(78));
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int num = Integer.bitCount(n);
        while (true) {
            int temp = Integer.bitCount(++n);
            if (num == temp) {
                return n;
            }
        }
    }
}
