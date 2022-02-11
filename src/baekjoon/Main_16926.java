package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소요 시간 : 664ms, 688ms
// 메모리 사용량 : 34176kb, 31948kb
public class Main_16926 {
    private static int n, m;
    private static int[][] arr;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int rNum = Math.min(n, m) / 2;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < rNum; j++) {
                rotation2(j, j, n - j - 1, m - j - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 방법 1 - 하드코딩
    private static void rotation1(int x1, int y1, int x2, int y2) {
        int temp = arr[x1][y1];
        for (int j = y1; j < y2; j++) { // 위
            arr[x1][j] = arr[x1][j + 1];
        }
        for (int i = x1; i < x2; i++) { // 오른쪽
            arr[i][y2] = arr[i + 1][y2];
        }
        for (int j = y2; j > y1; j--) { // 아래
            arr[x2][j] = arr[x2][j - 1];
        }
        for (int i = x2; i > x1; i--) { // 왼쪽
            arr[i][y1] = arr[i - 1][y1];
        }
        arr[x1 + 1][y1] = temp;
    }

    // 방법 2
    private static void rotation2(int x1, int y1, int x2, int y2) {
        int temp = arr[x1][y1];
        int d = 0, x = x1, y = y1;
        while (d < 4) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < x1 || nx > x2 || ny < x1 || ny > y2) {
                d++;
                continue;
            }
            arr[x][y] = arr[nx][ny];
            x = nx;
            y = ny;
        }
        arr[x1 + 1][y1] = temp;
    }
}
