package programmers;

// 가장 큰 정사각형 찾기
public class Solution_12905 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
    }

    public static int solution(int[][] board) {
        int answer = 1;
        boolean checkZero = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) checkZero = false;
                if (i == 0 || j == 0 || board[i][j] == 0) continue;
                board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                answer = Math.max(answer, board[i][j]);
            }
        }
        if (checkZero) return 0;
        return answer * answer;
    }
}
