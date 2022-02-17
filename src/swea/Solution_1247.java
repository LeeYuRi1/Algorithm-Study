package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//소요 시간 : 286 ms
//메모리 사용량 : 20,372 kb
public class Solution_1247 {
    private static int N, ans, customers[][], office[];
    private static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            ans = Integer.MAX_VALUE;
            customers = new int[N][2];
            visited = new boolean[N];
            int[] home = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            office = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            for (int i = 0; i < N; i++) {
                customers[i][0] = Integer.parseInt(st.nextToken());
                customers[i][1] = Integer.parseInt(st.nextToken());
            }
            find(0, 0, home[0], home[1]);
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void find(int cnt, int dist, int x, int y) {
        if (ans <= dist) return;
        if (cnt == N) {
            dist += getDist(x, y, office[0], office[1]);
            ans = Math.min(ans, dist);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int[] p = customers[i];
                find(cnt + 1, dist + getDist(x, y, p[0], p[1]), p[0], p[1]);
                visited[i] = false;
            }
        }
    }

    private static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
