package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 프림
// 소요 시간 : 173 ms
// 메모리 사용량 : 44,456 kb
public class Solution_1251 {
    private static int N;
    private static double E, adjMatrix[][], minEdge[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            int[][] point = new int[N][2];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < N; i++) {
                    point[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            E = Double.parseDouble(br.readLine());

            adjMatrix = new double[N][N];
            minEdge = new double[N];
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    adjMatrix[i][j] = adjMatrix[j][i] = getDist(i, j, point);
                }
                minEdge[i] = Double.MAX_VALUE;
            }
            minEdge[N - 1] = Double.MAX_VALUE;

            sb.append("#").append(tc).append(" ").append(prim()).append("\n");
        }
        System.out.println(sb);
    }

    private static long prim() {
        boolean[] visited = new boolean[N];
        double ans = 0;
        minEdge[0] = 0;
        for (int i = 0; i < N; i++) {
            double min = Double.MAX_VALUE;
            int minVertex = 0;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && min > minEdge[j]) {
                    min = minEdge[j];
                    minVertex = j;
                }
            }
            visited[minVertex] = true;
            ans += min * E;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && adjMatrix[minVertex][j] != 0 && minEdge[j] > adjMatrix[minVertex][j]) {
                    minEdge[j] = adjMatrix[minVertex][j];
                }
            }
        }
        return Math.round(ans);
    }

    private static double getDist(int i, int j, int[][] point) {
        return Math.pow(point[i][0] - point[j][0], 2) + Math.pow(point[i][1] - point[j][1], 2);
    }
}