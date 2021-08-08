package programmers;

import java.util.Arrays;

// 행렬 테두리 회전하기
public class Solution_77485 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] num = new int[rows][columns];
        int n = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                num[i][j] = n++;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(num, queries[i]);
        }
        return answer;
    }

    private static int rotate(int[][] num, int[] query) {
        int startX = query[0] - 1;
        int startY = query[1] - 1;
        int endX = query[2] - 1;
        int endY = query[3] - 1;

        int temp = num[startX][startY];
        int min = temp;
        // 왼쪽
        for (int i = startX; i < endX; i++) {
            num[i][startY] = num[i + 1][startY];
            min = Math.min(min, num[i][startY]);
        }
        // 아래쪽
        for (int i = startY; i < endY; i++) {
            num[endX][i] = num[endX][i + 1];
            min = Math.min(min, num[endX][i]);
        }
        // 오른쪽
        for (int i = endX; i > startX; i--) {
            num[i][endY] = num[i - 1][endY];
            min = Math.min(min, num[i][endY]);
        }
        // 위쪽
        for (int i = endY; i > startY; i--) {
            num[startX][i] = num[startX][i - 1];
            min = Math.min(min, num[startX][i]);
        }
        num[startX][startY + 1] = temp;
        return min;
    }
}
