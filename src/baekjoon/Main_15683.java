package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Point_15683 {
    int x;
    int y;
    int num;

    public Point_15683(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}

public class Main_15683 {
    private static int n, m;
    private static int[][] area;
    private static int[][] temp;
    private static ArrayList<Point_15683> cctv = new ArrayList<>();
    private static int[] arr;
    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        area = new int[n][m];
        temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                area[i][j] = Integer.parseInt(s2[j]);
                if (area[i][j] > 0 && area[i][j] < 6) cctv.add(new Point_15683(i, j, area[i][j]));
            }
        }
        arr = new int[cctv.size()];
        backtraking(0);
        System.out.println(ans);
    }

    // 4방향에 대해 백트래킹으로 모든 경우 구하기
    private static void backtraking(int depth) {
        if (depth == cctv.size()) {
            minBlindSpot();
            return;
        }
        for (int i = 1; i <= 4; i++) {
            arr[depth] = i;
            backtraking(depth + 1);
        }
    }

    // 정한 방향에 대해 사각지대 크기 구하기
    private static void minBlindSpot() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = area[i][j];
            }
        }
        for (int i = 0; i < cctv.size(); i++) {
            int x = cctv.get(i).x;
            int y = cctv.get(i).y;
            int cctvNum = cctv.get(i).num;
            int dir = arr[i];
            switch (cctvNum) {
                case 1:
                    if (dir == 1) check(x, y, 0, 1); //오른쪽
                    else if (dir == 2) check(x, y, 1, 0); //아래
                    else if (dir == 3) check(x, y, 0, -1); //왼쪽
                    else check(x, y, -1, 0); //위
                    break;
                case 2:
                    if (dir >= 2) {
                        check(x, y, 0, 1); //오른쪽
                        check(x, y, 0, -1); //왼쪽
                    } else {
                        check(x, y, 1, 0); //아래
                        check(x, y, -1, 0); //위
                    }
                    break;
                case 3:
                    if (dir == 1) {
                        check(x, y, -1, 0); //위
                        check(x, y, 0, 1); //오른쪽
                    } else if (dir == 2) {
                        check(x, y, 0, 1); //오른쪽
                        check(x, y, 1, 0); //아래
                    } else if (dir == 3) {
                        check(x, y, 1, 0); //아래
                        check(x, y, 0, -1); //왼쪽
                    } else {
                        check(x, y, 0, -1); //왼쪽
                        check(x, y, -1, 0); //위
                    }
                    break;
                case 4:
                    if (dir == 1) {
                        check(x, y, 0, -1); //왼쪽
                        check(x, y, -1, 0); //위
                        check(x, y, 0, 1); //오른쪽
                    } else if (dir == 2) {
                        check(x, y, -1, 0); //위
                        check(x, y, 0, 1); //오른쪽
                        check(x, y, 1, 0); //아래
                    } else if (dir == 3) {
                        check(x, y, 0, 1); //오른쪽
                        check(x, y, 1, 0); //아래
                        check(x, y, 0, -1); //왼쪽
                    } else {
                        check(x, y, 1, 0); //아래
                        check(x, y, 0, -1); //왼쪽
                        check(x, y, -1, 0); //위
                    }
                    break;
                case 5:
                    // 모든 방향
                    check(x, y, 0, 1);
                    check(x, y, 1, 0);
                    check(x, y, 0, -1);
                    check(x, y, -1, 0);
                    break;
            }
        }
        //사각지대 최소값 구하기
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) count++;
            }
        }
        ans = Math.min(ans, count);
    }

    // cctv가 감시할 수 있는 곳 체크하기
    private static void check(int x, int y, int dx, int dy) {
        while (true) {
            x += dx;
            y += dy;
            if (x < 0 || x >= n || y < 0 || y >= m || temp[x][y] == 6) break;
            temp[x][y] = 7;
        }
    }
}
