package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503 {
    private static int r, c, d, area[][];
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        area = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(clean());
    }

    private static int clean() {
        int count = 0, nx = 0, ny = 0;
        boolean flag = false;
        while (true) {
            if (area[r][c] == 0) {
                area[r][c] = 2;
                count++;
            }
            flag = false;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                nx = r + dx[d];
                ny = c + dy[d];
                if (area[nx][ny] > 0) continue;
                flag = true;
                break;
            }
            if (!flag) {
                int nd = (d + 2) % 4;
                nx = r + dx[nd];
                ny = c + dy[nd];
                if (area[nx][ny] == 1) break;
            }
            r = nx;
            c = ny;
        }
        return count;
    }
}
