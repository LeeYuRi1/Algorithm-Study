package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4386 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        double[][] stars = new double[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
        }
        double[][] dist = new double[N][N];
        double[] minEdge = new double[N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double d = Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(stars[i][1] - stars[j][1], 2));
                dist[i][j] = dist[j][i] = d;
            }
            minEdge[i] = Integer.MAX_VALUE;
        }

        double ans = 0;
        minEdge[0] = 0;
        for (int i = 0; i < N; i++) {
            double min = Double.MAX_VALUE;
            int minV = 0;
            for (int j = 0; j < N; j++) {
                if (visited[j] || minEdge[j] >= min) continue;
                min = minEdge[j];
                minV = j;
            }
            visited[minV] = true;
            ans += min;

            for (int j = 0; j < N; j++) {
                if (visited[j] || dist[minV][j] == 0) continue;
                if (minEdge[j] > dist[minV][j]) minEdge[j] = dist[minV][j];
            }
        }
        System.out.println(String.format("%.2f", ans));
    }
}
