package programmers;

import java.util.LinkedList;
import java.util.Queue;

// 프렌즈4블록
public class Solution_17679 {
    private static String[][] area;
    private static int answer = 0;
    private static int[] dx = {0, 1, 0, 1};
    private static int[] dy = {0, 0, 1, 1};

    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
    }

    public static int solution(int m, int n, String[] board) {
        area = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                area[i][j] = board[i].charAt(j) + "";
            }
        }
        while (step1(m, n)) {
            step2(m, n);
        }
        return answer;
    }

    // 사라지는게 있으면 true, 없으면 false
    private static boolean step1(int m, int n) {
        boolean[][] check = new boolean[m][n];
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                int count = 0;
                String s = area[i][j];
                if (s.equals("*")) continue;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (area[nx][ny].equals(s)) count++;
                }
                if (count != 4) continue;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    check[nx][ny] = true;
                }
            }
        }
        boolean result = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) continue;
                area[i][j] = "*";
                result = true;
                answer++;
            }
        }
        return result;
    }

    // 아래로 떨어짐
    private static void step2(int m, int n) {
        for (int j = 0; j < n; j++) {
            Queue<String> queue = new LinkedList<>();
            for (int i = m - 1; i >= 0; i--) {
                if (!area[i][j].equals("*")) queue.offer(area[i][j]);
            }
            for (int i = m - 1; i >= 0; i--) {
                if (!queue.isEmpty()) area[i][j] = queue.poll();
                else area[i][j] = "*";
            }
        }
    }
}
