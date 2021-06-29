package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_15685 {
    private static boolean[][] check = new boolean[102][102];
    private static ArrayList<Integer> curve = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        setCurve();
        while (n-- > 0) {
            String[] s = br.readLine().split(" ");
            // x,y 바꾸기
            draw(Integer.parseInt(s[1]), Integer.parseInt(s[0]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));
        }

        // check == true인 곳이 나오면 i,j를 사각형 왼쪽 위 기준으로 검사함
        int ans = 0;
        for (int i = 0; i < check.length; i++) {
            for (int j = 0; j < check[i].length; j++) {
                if (!check[i][j]) continue;
                int[] dx = {0, 1, 1}; //오른쪽, 대각선아래쪽, 아래쪽
                int[] dy = {1, 1, 0};
                boolean sq = true;
                for (int k = 0; k < 3; k++) {
                    if (!check[i + dx[k]][j + dy[k]]) sq = false;
                }
                if (sq) ans++;
            }
        }
        System.out.println(ans);
    }

    // 드래곤커브 규칙: 이전 세대에서 반대로 +1
    private static void setCurve() {
        curve.add(0);
        curve.add(1);
        curve.add(2);
        curve.add(1);
        for (int i = 3; i <= 10; i++) {
            for (int j = curve.size() - 1; j >= 0; j--) {
                curve.add((curve.get(j) + 1) % 4);
            }
        }
    }

    // 정해놓은 규칙대로 true 표시
    private static void draw(int x, int y, int d, int g) {
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        check[x][y] = true;
        for (int i = 0; i < Math.pow(2, g); i++) {
            int nd = (curve.get(i) + d) % 4;
            x += dx[nd];
            y += dy[nd];
            check[x][y] = true;
        }
    }
}
