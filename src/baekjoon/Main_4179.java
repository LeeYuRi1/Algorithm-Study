package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_4179 {
    private static String[][] area;
    private static int[][] distJ;
    private static int[][] distF;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int r = Integer.parseInt(s1[0]);
        int c = Integer.parseInt(s1[1]);
        area = new String[r][c];
        distJ = new int[r][c];
        distF = new int[r][c];
        Queue<int[]> queueJ = new LinkedList<>();
        Queue<int[]> queueF = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            Arrays.fill(distJ[i], -1);
            Arrays.fill(distF[i], -1);
            String[] s2 = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                area[i][j] = s2[j];
                if (area[i][j].equals("J")) {
                    queueJ.offer(new int[]{i, j});
                    distJ[i][j] = 0;
                } else if (area[i][j].equals("F")) {
                    queueF.offer(new int[]{i, j});
                    distF[i][j] = 0;
                }
            }
        }
        bfsF(queueF, r, c);
        bfsJ(queueJ, r, c);
    }

    private static void bfsF(Queue<int[]> queueF, int r, int c) {
        while (!queueF.isEmpty()) {
            int[] p = queueF.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (area[nx][ny].equals("#") || distF[nx][ny] != -1) continue;
                distF[nx][ny] = distF[p[0]][p[1]] + 1;
                queueF.offer(new int[]{nx, ny});
            }
        }
    }

    private static void bfsJ(Queue<int[]> queueJ, int r, int c) {
        while (!queueJ.isEmpty()) {
            int[] p = queueJ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    System.out.println(distJ[p[0]][p[1]] + 1);
                    return;
                }
                if (distF[nx][ny] != -1 && distJ[p[0]][p[1]] + 1 >= distF[nx][ny]) continue;
                if (area[nx][ny].equals("#") || distJ[nx][ny] != -1) continue;
                distJ[nx][ny] = distJ[p[0]][p[1]] + 1;
                queueJ.offer(new int[]{nx, ny});
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
