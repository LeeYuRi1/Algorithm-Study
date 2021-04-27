package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2252 {

    private static ArrayList<Integer>[] g;
    private static int[] indegree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        g = new ArrayList[n + 1];
        indegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            g[a].add(b);
            indegree[b]++;
        }
        topologicalSort(n);
    }

    private static void topologicalSort(int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int x = q.remove();
            System.out.print(x + " ");
            for (int y : g[x]) {
                indegree[y]--;
                if (indegree[y] == 0) q.add(y);
            }
        }
    }
}
