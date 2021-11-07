package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16967 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int h = Integer.parseInt(input1[0]);
        int w = Integer.parseInt(input1[1]);
        int x = Integer.parseInt(input1[2]);
        int y = Integer.parseInt(input1[3]);
        int[][] a = new int[h][w];
        int[][] b = new int[h + x][w + y];
        for (int i = 0; i < h + x; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < w + y; j++) {
                b[i][j] = Integer.parseInt(input2[j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i - x >= 0 && j - y >= 0) a[i][j] = b[i][j] - a[i - x][j - y];
                else a[i][j] = b[i][j];
                sb.append(a[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
