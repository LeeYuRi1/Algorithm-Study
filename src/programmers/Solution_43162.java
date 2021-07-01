package programmers;

// 네트워크
public class Solution_43162 {

    private static boolean[] check;

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }

    private static void dfs(int x, int[][] com) {
        check[x] = true;
        for (int y = 0; y < com.length; y++) {
            if (!check[y] && com[x][y] == 1) dfs(y, com);
        }
    }
}
