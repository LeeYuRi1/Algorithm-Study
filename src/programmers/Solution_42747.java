package programmers;

// H-Index
public class Solution_42747 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println(solution(new int[]{10, 11, 12, 13}));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        for (int i = citations.length; i >= 0; i--) {
            int above = 0;
            int below = 0;
            for (int n = 0; n < citations.length; n++) {
                if (citations[n] >= i) above++;
            }
            below = citations.length - above;
            if (above >= i && below <= i) return i;
        }
        return answer;
    }
}
