package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소요 시간 : 228 ms
// 메모리 사용량 : 23380 kb
public class Main_17144 {
    private static int R, C, point, area[][];
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        area = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (area[i][j] == -1) point = i;
            }
        }
        while (T-- > 0) {
            step1();
            step2(true, 0, point - 1, 0, point); // 위쪽
            step2(false, 2, point, point, R); // 아래쪽
        }
        System.out.println(getSumAmount());
    }

    // 미세먼지 확산
    private static void step1() {
        int[][] temp = new int[R][C];
        temp[point - 1][0] = -1;
        temp[point][0] = -1;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (area[i][j] <= 0) continue;
                int count = 0;
                int sum = area[i][j] / 5;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C || area[nx][ny] == -1) continue;
                    temp[nx][ny] += sum;
                    count++;
                }
                temp[i][j] += area[i][j] - (sum * count);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                area[i][j] = temp[i][j];
            }
        }
    }

    // 공기청정기 작동
    private static void step2(boolean top, int ds, int p, int minX, int maxX) {
        int d = ds;
        int x = p, y = 0, cnt = 0;
        while (cnt < 4) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < minX || nx >= maxX || ny < 0 || ny >= C) {
                if (top) d++;
                else d = (d + 3) % 4;
                cnt++;
                continue;
            }
            area[x][y] = area[nx][ny];
            x = nx;
            y = ny;
        }
        area[p][0] = -1;
        area[p][1] = 0;
    }

    private static int getSumAmount() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (area[i][j] != -1) sum += area[i][j];
            }
        }
        return sum;
    }
}
