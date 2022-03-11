package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Edge_1865 {
    int from, to, time;

    Edge_1865(int from, int to, int time) {
        this.from = from;
        this.to = to;
        this.time = time;
    }
}

public class Main_1865 {
    private static int N;
    private static List<Edge_1865> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if (i < M) {
                    list.add(new Edge_1865(a, b, c));
                    list.add(new Edge_1865(b, a, c));
                } else {
                    list.add(new Edge_1865(a, b, -c));
                }
            }
            sb.append(bellmanFord()).append("\n");
        }
        System.out.println(sb);
    }

    private static String bellmanFord() {
        long[] ans = new long[N + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[1] = 0;
        for (int i = 1; i <= N; i++) {
            for (Edge_1865 e : list) {
//                if (ans[e.from] == Integer.MAX_VALUE) continue; // 최단거리가 아닌 사이클만 찾아야하기 때문!
                if (ans[e.to] > ans[e.from] + e.time) {
                    ans[e.to] = ans[e.from] + e.time;
                    if (i == N) return "YES";
                }
            }
        }
        return "NO";
    }
}
