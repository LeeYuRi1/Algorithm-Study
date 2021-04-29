package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1516 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] a = new ArrayList[n + 1];
        int[] indegree = new int[n + 1];
        int[] time = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int t = Integer.parseInt(st.nextToken());
                if (t == -1) break;
                a[t].add(i);
                indegree[i]++;
            }
        }
        topologicalSort(a, indegree, time, n);
    }

    private static void topologicalSort(ArrayList<Integer>[] a, int[] indegree, int[] time, int n) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) q.offer(i);
            ans[i] = time[i];
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : a[x]) {
                indegree[y]--;
                ans[y] = Math.max(ans[y], ans[x] + time[y]);
                if (indegree[y] == 0) {
                    q.offer(y);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(ans[i]);
        }
    }
}
