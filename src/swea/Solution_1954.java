package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소요 시간 : 99 ms
// 메모리 사용량 : 16,080 kb
public class Solution_1954 {
    private static int n;
    private static int[][] arr;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            fill1();
//            fill2();
//            fillRecursion(0, 0, 0, 1);
            print(testCase);
        }
        System.out.println(sb);
    }

    private static void fill1() {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0, nx = 0, ny = 0, d = 0, num = 1;
        arr[x][y] = num;
        if (n == 1) return;
        while (true) {
            nx = x + dx[d];
            ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] != 0) {
                d = (d + 1) % 4;
                if (arr[x + dx[d]][y + dy[d]] != 0) break;
                continue;
            }
            x = nx;
            y = ny;
            arr[x][y] = ++num;
        }
    }

    private static void fill2() {
        int x = 0, y = 0, nx = 0, ny = 0;
        int d = 0, target = n * n, i = 1;
        while (i <= target) {
            arr[x][y] = i; // 현위치에 값 세팅
            // 다음 위치
            nx = x + dx[d];
            ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] != 0) {
                d = (d + 1) % 4;
                x += dx[d];
                y += dy[d];
            } else {
                x = nx;
                y = ny;
            }
            i++;
        }
    }

    private static void fillRecursion(int x, int y, int d, int no) {
        if (no > n * n) return;
        arr[x][y] = no;
        int nx = x + dx[d];
        int ny = y + dy[d];
        if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] != 0) {
            int nd = (d + 1) % 4;
            fillRecursion(x + dx[nd], y + dy[nd], nd, no + 1);
        } else {
            fillRecursion(nx, ny, d, no + 1);
        }
    }

    private static void print(int testCase) {
        sb.append("#" + testCase + "\n");
        for (int[] i : arr) {
            for (int j : i) {
                sb.append(j + " ");
            }
            sb.append("\n");
        }
    }
}
