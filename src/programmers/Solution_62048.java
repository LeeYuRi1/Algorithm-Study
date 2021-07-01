package programmers;

// 멀쩡한 사각형
public class Solution_62048 {
    public static void main(String[] args) {
        System.out.println(solution(8, 12));
    }

    public static long solution(int w, int h) {
        long wl = (long) w;
        long hl = (long) h;
        return (wl * hl) - (wl + hl - gcd(wl, hl));
    }

    private static long gcd(long w, long h) {
        if (h == 0) return w;
        return gcd(h, w % h);
    }
}
