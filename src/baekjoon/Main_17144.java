package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17144 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int r = Integer.parseInt(s1[0]);
        int c = Integer.parseInt(s1[1]);
        int t = Integer.parseInt(s1[2]);
        int[][] room = new int[r][c];
        int point = 0;
        for (int i = 0; i < r; i++) {
            String[] s2 = br.readLine().split(" ");
            for (int j = 0; j < c; j++) {
                if (Integer.parseInt(s2[j]) == -1) point = i;
                room[i][j] = Integer.parseInt(s2[j]);
            }
        }
        while (t-- > 0) {
            room = diffusion(room, r, c);
            cumulative(room, point, r, c);
        }
        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (room[i][j] != -1) ans += room[i][j];
            }
        }
        System.out.println(ans);
    }

    // 미세먼지 확산
    private static int[][] diffusion(int[][] room, int r, int c) {
        int[][] temp = new int[r][c];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (room[i][j] == -1) temp[i][j] = -1;
                else if (room[i][j] > 0) {
                    temp[i][j] += room[i][j];
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                            if (room[nx][ny] != -1) {
                                temp[nx][ny] += room[i][j] / 5;
                                temp[i][j] -= room[i][j] / 5;
                            }
                        }
                    }
                }
            }
        }
        return temp;
    }

    // 공기청정기 가동
    private static void cumulative(int[][] room, int point, int r, int c) {
        // 위쪽 - 반시계방향
        point--;
        for (int i = point - 1; i > 0; i--) {
            room[i][0] = room[i - 1][0];
        }
        for (int i = 0; i < c - 1; i++) {
            room[0][i] = room[0][i + 1];
        }
        for (int i = 0; i < point; i++) {
            room[i][c - 1] = room[i + 1][c - 1];
        }
        for (int i = c - 1; i > 1; i--) {
            room[point][i] = room[point][i - 1];
        }
        room[point][1] = 0;

        // 아래쪽 - 시계방향
        point++;
        for (int i = point + 1; i < r - 1; i++) {
            room[i][0] = room[i + 1][0];
        }
        for (int i = 0; i < c - 1; i++) {
            room[r - 1][i] = room[r - 1][i + 1];
        }
        for (int i = r - 1; i > point; i--) {
            room[i][c - 1] = room[i - 1][c - 1];
        }
        for (int i = c - 1; i > 0; i--) {
            room[point][i] = room[point][i - 1];
        }
        room[point][1] = 0;
    }
}
