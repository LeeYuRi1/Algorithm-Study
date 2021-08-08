package programmers;

// 예상 대진표
public class Solution_12985 {
    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
        System.out.println(solution(8, 1, 2));
    }

    public static int solution(int n, int a, int b) {
        int answer = 0;
        while (a != b) {
            a = (a + 1) / 2; // 홀수인 경우를 생각해서 1을 더해줌
            b = (b + 1) / 2;
            answer++;
        }
        return answer;
    }
}
