package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2056 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] g = new ArrayList[n + 1];
        int[] indegree = new int[n + 1];
        int[] time = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            indegree[i] = m;
            for (int j = 2; j < m + 2; j++) {
                g[Integer.parseInt(st.nextToken())].add(i);
            }
        }
        System.out.println(topologicalSort(g, indegree, time, n));
    }

    private static int topologicalSort(ArrayList<Integer>[] g, int[] indegree, int[] time, int n) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int[] ans = new int[n + 1];
        for (int i = 1; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
            ans[i] = time[i];
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : g[x]) {
                indegree[y]--;
                ans[y] = Math.max(ans[y], ans[x] + time[y]);
                if (indegree[y] == 0) {
                    q.offer(y);
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, ans[i]);
        }
        return max;
    }
}
