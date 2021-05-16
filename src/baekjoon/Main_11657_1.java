package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge_11657_1 {
    int from;
    int to;
    int cost;

    Edge_11657_1(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

// 벨만포드 사용
public class Main_11657_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        ArrayList<Edge_11657_1> g = new ArrayList<>();
        long[] d = new long[501];
        int inf = 100000000;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g.add(new Edge_11657_1(a, b, c));
        }
        for (int i = 1; i <= n; i++) {
            d[i] = inf;
        }

        d[1] = 0;
        boolean negativeCycle = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                int x = g.get(j).from;
                int y = g.get(j).to;
                int z = g.get(j).cost;
                if (d[x] != inf && d[y] > d[x] + z) {
                    d[y] = d[x] + z;
                    if (i == n) negativeCycle = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (negativeCycle) {
            sb.append(-1);
        } else {
            for (int i = 2; i <= n; i++) {
                if (d[i] == inf) d[i] = -1;
                sb.append(d[i] + "\n");
            }
        }
        System.out.println(sb);
    }
}
