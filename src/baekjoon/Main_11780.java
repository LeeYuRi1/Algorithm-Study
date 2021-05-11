package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_11780 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] g = new int[n + 1][n + 1];
        int[][] v = new int[n + 1][n + 1];
        int inf = 100000000;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) g[i][j] = 0;
                else g[i][j] = inf;
            }
        }
        while (m-- > 0) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            g[a][b] = Math.min(g[a][b], c);
            v[a][b] = a;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (g[i][j] > g[i][k] + g[k][j]) {
                        g[i][j] = g[i][k] + g[k][j];
                        v[i][j] = v[k][j];
                    }
                }
            }
        }
        print(g, v, n, inf);
    }

    private static void print(int[][] g, int[][] v, int n, int inf) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (g[i][j] == inf) sb.append("0 ");
                else sb.append(g[i][j] + " ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (g[i][j] == inf || g[i][j] == 0) sb.append("0\n");
                else {
                    Stack<Integer> stack = new Stack<>();
                    int x = j;
                    stack.push(j);
                    while (i != v[i][x]) {
                        x = v[i][x];
                        stack.push(x);
                    }
                    stack.add(i);
                    sb.append(stack.size() + " ");
                    while (!stack.isEmpty()) sb.append(stack.pop() + " ");
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
