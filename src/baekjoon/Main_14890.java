package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14890 {
    private static int[][] map;
    private static int n, l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        l = Integer.parseInt(input1[1]);
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input2[j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (move(i, 0, 0)) ans++;
            if (move(0, i, 1)) ans++;
        }
        System.out.println(ans);
    }

    private static boolean move(int x, int y, int d) {
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (d == 0) arr[i] = map[x][y + i];
            else arr[i] = map[x + i][y];
        }

        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) > 1) return false;
            if (arr[i] == arr[i + 1]) continue;
            if (arr[i] < arr[i + 1]) { // 올라가는 경사
                for (int j = i; j > i - l; j--) {
                    if (j < 0 || visited[j] || arr[i] != arr[j]) return false;
                    visited[j] = true;
                }
            }
            if (arr[i] > arr[i + 1]) { // 내려가는 경사
                for (int j = i + 1; j <= i + l; j++) {
                    if (j >= n || visited[j] || arr[i + 1] != arr[j]) return false;
                    visited[j] = true;
                }
            }
        }
        return true;
    }
}
