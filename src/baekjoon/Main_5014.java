package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5014 {
    private static int F, U, D, dist[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dist = new int[F + 1];
        String ans = (S < G && U == 0) || (S > G && D == 0) ? "use the stairs" : bfs(S, G);
        System.out.println(ans);
    }

    private static String bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dist[start] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == end) return (dist[cur] - 1) + "";
            int uc = cur + U;
            int dc = cur - D;
            if (uc <= F && dist[uc] == 0) {
                queue.offer(uc);
                dist[uc] = dist[cur] + 1;
            }
            if (dc > 0 && dist[dc] == 0) {
                queue.offer(dc);
                dist[dc] = dist[cur] + 1;
            }
        }
        return "use the stairs";
    }
}