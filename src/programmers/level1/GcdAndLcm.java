package programmers.level1;

// 최대공약수와 최소공배수
public class GcdAndLcm {
    public static void main(String[] args) {
        System.out.println(solution(3, 12));
    }

    static public int[] solution(int n, int m) {
        int g = gcd(n, m);
        return new int[]{g, n * m / g};
    }

    private static int gcd(int n, int m) {
        if (m == 0) return n;
        return gcd(m, n % m);
    }
}
