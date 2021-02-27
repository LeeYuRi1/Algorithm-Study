package programmers.level2;

// 124 나라의 숫자
public class NumberOf124Countries {
    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(40));

    }

    static public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int r = 0;
        while (n != 0) {
            r = n % 3;
            n /= 3;
            if (r == 0) {
                n -= 1;
                r = 4;
            }
            sb.append(r);
        }
        return sb.reverse().toString();
    }
}