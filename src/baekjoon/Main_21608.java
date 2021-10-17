package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_21608 {
    private static int n;
    private static int[][] area;
    private static HashSet[] like;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        area = new int[n][n];
        like = new HashSet[n * n + 1];
        for (int i = 0; i < n * n; i++) {
            String[] input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]);
            like[num] = new HashSet();
            for (int j = 0; j < 4; j++) {
                like[num].add(Integer.parseInt(input[j + 1]));
            }
            setPosition(num);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int num = area[i][j];
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (like[num].contains(area[nx][ny])) sum++;
                }
                if (sum == 1) ans += 1;
                else if (sum == 2) ans += 10;
                else if (sum == 3) ans += 100;
                else if (sum == 4) ans += 1000;
            }
        }
        System.out.println(ans);
    }

    private static void setPosition(int num) {
        // 1. 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 정함 - 가중치 크게 줌
        // 2. 여러개면 인접한 칸 중 비어있는 칸이 가장 많은 칸으로 정함
        int x = 0;
        int y = 0;
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (area[i][j] != 0) continue;
                int sum = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (like[num].contains(area[nx][ny])) sum += 5;
                    else if (area[nx][ny] == 0) sum += 1;
                }
                if (sum > max) {
                    max = sum;
                    x = i;
                    y = j;
                }
            }
        }
        area[x][y] = num;
    }
}
