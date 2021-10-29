package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 삼각 달팽이
public class Solution_68645 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5)));
    }

    public static int[] solution(int n) {
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        int[][] tri = new int[n][n];
        int x = -1, y = 0;
        int d = 2;
        int num = 1;
        for (int i = 0; i < n; i++) {
            d = (d + 1) % 3;
            for (int j = 0; j < n - i; j++) {
                x += dx[d];
                y += dy[d];
                tri[x][y] = num++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tri[i][j] != 0) result.add(tri[i][j]);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
