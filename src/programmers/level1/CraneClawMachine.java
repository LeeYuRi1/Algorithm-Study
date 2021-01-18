package programmers.level1;

import java.util.Stack;

//크레인 인형뽑기 게임
public class CraneClawMachine {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution(board, moves));
    }

    static public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            int m = moves[i] - 1;
            for (int j = 0; j < board.length; j++) {
                if (board[j][m] != 0) {
                    if (!stack.isEmpty() && stack.peek() == board[j][m]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[j][m]);
                    }
                    board[j][m] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
