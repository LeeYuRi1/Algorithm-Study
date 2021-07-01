package programmers;

// 주식가격
public class Solution_42584 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 2, 3}));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) break;
            }
        }
        return answer;
    }
}
