package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_14503 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        int[][] area = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s3 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                area[i][j] = Integer.parseInt(s3[j]);
            }
        }

        int[] dx = {-1, 0, 1, 0}; //북동남서
        int[] dy = {0, 1, 0, -1};
        int r = Integer.parseInt(s2[0]);
        int c = Integer.parseInt(s2[1]);
        int d = Integer.parseInt(s2[2]);
        int ans = 0;
        while (true) {
            if (area[r][c] == 0) {
                ans++;
                area[r][c] = 2;
            }
            boolean check = false;
            int dir = d;
            for (int i = 0; i < 4; i++) {
                int nd = (d + 3) % 4;
                int nx = r + dx[nd];
                int ny = c + dy[nd];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (area[nx][ny] == 0) { // a, b
                        d = nd;
                        r = nx;
                        c = ny;
                        check = true;
                        break;
                    }
                }
                d = (d + 3) % 4;
            }
            if (!check) {
                int nd = (dir + 2) % 4;
                int nx = r + dx[nd];
                int ny = c + dy[nd];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (area[nx][ny] == 1) break; // d
                    else { // c
                        r = nx;
                        c = ny;
                        d = dir;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
