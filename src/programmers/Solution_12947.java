package programmers;

// 하샤드 수
// x의 각 자릿수의 합으로 x가 나누어지는 양의 정수
public class Solution_12947 {
    public static void main(String[] args) {
        System.out.println(solution1(10));
        System.out.println(solution1(12));
        System.out.println(solution2(11));
        System.out.println(solution2(13));
    }

    // x를 10으로 나누어 1의자리를 구하는 방식
    public static boolean solution1(int x) {
        int sum = 0;
        int n = x;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return x % sum == 0;
    }

    // 문자열로 바꾸어 각 자릿수를 변환하는 방식
    public static boolean solution2(int x) {
        String s = String.valueOf(x);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
//            sum += Character.getNumericValue(s.charAt(i));
        }
        return x % sum == 0;
    }
}
