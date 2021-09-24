package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14503 {
    private static int[][] area;
    private static int[] dx = {-1, 0, 1, 0}; //상우하좌
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        area = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input3 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                area[i][j] = Integer.parseInt(input3[j]);
            }
        }
        System.out.println(move(Integer.parseInt(input2[0]), Integer.parseInt(input2[1]), Integer.parseInt(input2[2])));
    }

    private static int move(int x, int y, int d) {
        int ans = 0;
        while (true) {
            if (area[x][y] == 0) {
                area[x][y] = 2; // 1. 현재 위치를 청소
                ans++;
            }
            int count = 0;
            for (int i = 0; i < 4; i++) { // 2. 왼쪽 방향부터 차례대로 탐색
                d = (d + 3) % 4;
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (area[nx][ny] == 0) { // a. 청소하지 않은 공간 존재하면, 그 방향으로 회전하고 한칸 전진하고 1번부터 진행
                    x = nx;
                    y = ny;
                    break;
                }
                count++;
                // b. 청소할 공간 없다면, 그 방향으로 회전하고 2번으로 돌아감
            }
            if (count == 4) { // 네 방향 모두 청소가 이미 되어있거나 벽이면
                int nd = (d + 2) % 4; // 뒤쪽 방향
                int nx = x + dx[nd];
                int ny = y + dy[nd];
                if (area[nx][ny] == 1) return ans; // d. 벽이라 후진할 수 없으면 멈춤
                x = nx; // c. 한 칸 후진하고 2번으로 돌아감
                y = ny;
            }
        }
    }
}
