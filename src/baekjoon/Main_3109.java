package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//소요 시간 : 280 ms
//메모리 사용량 : 36888 kb
public class Main_3109 {
    private static int R, C, count = 0;
    private static char[][] area;
    private static int[] dx = {-1, 0, 1}; // dy는 모두 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        area = new char[R][];
        for (int i = 0; i < R; i++) {
            area[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < R; i++) {
            dfs(i, 0);
        }
        System.out.println(count);
    }

    private static boolean dfs(int x, int y) {
        if (y == C - 1) {
            count++;
            return true;
        }
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + 1;
            if (nx < 0 || nx >= R || area[nx][ny] == 'x') continue;
            area[nx][ny] = 'x';
            if (dfs(nx, ny)) return true; // 가지치기 방지!!!
        }
        return false;
    }
}
