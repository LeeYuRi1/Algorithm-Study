package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Edge_1916 {
    int to;
    int cost;

    Edge_1916(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

// 다익스트라 - 일반 배열 이용
public class Main_1916 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Edge_1916>[] a = new ArrayList[n + 1];
        int[] d = new int[n + 1];
        boolean[] c = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            a[x].add(new Edge_1916(y, w));
        }
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        int inf = 100000000;
        for (int i = 1; i <= n; i++) {
            d[i] = inf;
        }
        d[start] = 0;
        for (int i = 0; i < n - 1; i++) {
            int min = inf + 1;
            int x = -1;
            for (int j = 1; j <= n; j++) {
                if (!c[j] && min > d[j]) {
                    min = d[j];
                    x = j;
                }
            }
            c[x] = true;
            for (Edge_1916 j : a[x]) {
                int y = j.to;
                int w = j.cost;
                if (d[y] > d[x] + w) {
                    d[y] = d[x] + w;
                }
            }
        }
        System.out.println(d[end]);
    }
}
