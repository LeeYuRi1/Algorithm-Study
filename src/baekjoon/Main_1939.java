package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Edge {
    public int v;
    public int w;

    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

public class Main_1939 {

    private static List<Edge>[] list;
    private static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        list = new ArrayList[n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= m; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            max = Math.max(max, c);
            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
        }
        String[] s = br.readLine().split(" ");
        System.out.println(find(Integer.parseInt(s[0]), Integer.parseInt(s[1]), n, max));
    }

    private static int find(int start, int end, int n, int m) {
        int min = 1;
        int max = m;
        int ans = 0;
        while (min <= max) {
            check = new boolean[n + 1];
            int mid = (min + max) / 2;
            if (dfs(start, end, mid)) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return ans;
    }

    private static boolean dfs(int start, int end, int mid) {
        if (check[start]) return false;
        check[start] = true;
        if (start == end) return true;
        for (Edge e : list[start]) {
            if (mid <= e.w) {
                if (dfs(e.v, end, mid)) return true;
            }
        }
        return false;
    }
}
