package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 소요 시간 : 108 ms
// 메모리 사용량 : 19,620 kb
public class Solution_1238 {
    private static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            adjList = new ArrayList[101];
            for (int i = 1; i <= 100; i++) {
                adjList[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < len / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjList[from].add(to);
            }
            System.out.println("#" + tc + " " + bfs(start, new int[101]));
        }
    }

    private static int bfs(int start, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = 1;
        int maxDepth = 0, ans = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i : adjList[cur]) {
                if (visited[i] != 0) continue;
                queue.offer(i);
                visited[i] = visited[cur] + 1;
            }
            maxDepth = visited[cur];
        }
        for (int i = 1; i <= 100; i++) {
            if (visited[i] == maxDepth) ans = Math.max(ans, i);
        }
        return ans;
    }
}
