package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_18428 {
    private static int n;
    private static String[][] area;
    private static ArrayList<int[]> t = new ArrayList<>();
    private static boolean ans = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        area = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                area[i][j] = s[j];
                if (area[i][j].equals("T")) t.add(new int[]{i, j});
            }
        }
        backtracking(0);
        if (ans) System.out.println("YES");
        else System.out.println("NO");
    }

    // 3개의 장애물 설치하는 모든 경우 구하기
    private static void backtracking(int depth) {
        if (depth == 3) {
            check();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (area[i][j].equals("X")) {
                    area[i][j] = "O";
                    backtracking(depth + 1);
                    area[i][j] = "X";
                }
            }
        }
    }

    // 각 선생님의 위치에서 상하좌우 검사
    private static void check() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < t.size(); i++) {
            for (int j = 0; j < 4; j++) {
                int x = t.get(i)[0];
                int y = t.get(i)[1];
                while (true) {
                    x += dx[j];
                    y += dy[j];
                    if (x < 0 || x >= n || y < 0 || y >= n || area[x][y].equals("O")) break;
                    if (area[x][y].equals("S")) return;
                }
            }
        }
        ans = true;
    }
}
