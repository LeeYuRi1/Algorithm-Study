package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Edge_1865 {
    int from;
    int to;
    int cost;

    Edge_1865(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class Main_1865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            ArrayList<Edge_1865> g = new ArrayList<>();
            for (int i = 0; i < m + w; i++) {
                String[] input2 = br.readLine().split(" ");
                int s = Integer.parseInt(input2[0]);
                int e = Integer.parseInt(input2[1]);
                int t = Integer.parseInt(input2[2]);
                if (i < m) {
                    g.add(new Edge_1865(s, e, t));
                    g.add(new Edge_1865(e, s, t));
                } else {
                    g.add(new Edge_1865(s, e, -t));
                }
            }
            sb.append(bellmanFord(g, n, m) + "\n");
        }
        System.out.println(sb);
    }

    private static String bellmanFord(ArrayList<Edge_1865> g, int n, int m) {
        int[] d = new int[n + 1];
        Arrays.fill(d, 100000000);
        d[1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < g.size(); j++) {
                int s = g.get(j).from;
                int e = g.get(j).to;
                int t = g.get(j).cost;
                if (d[e] <= d[s] + t) continue;
                d[e] = d[s] + t;
                if (i == n) return "YES";
            }
        }
        return "NO";
    }
}
