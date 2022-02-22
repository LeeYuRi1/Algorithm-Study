package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 소요 시간 : 128 ms
// 메모리 사용량 : 27,272 kb
public class Solution_7465 {
    private static List<Integer>[] adj;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            adj = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }
            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                adj[b].add(a);
            }
            int ans = 0;
            for (int i = 1; i <= N; i++) {
                if (visited[i]) continue;
                dfs(i);
                ans++;
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int x) {
        visited[x] = true;
        for (int y : adj[x]) {
            if (!visited[y]) dfs(y);
        }
    }
}
