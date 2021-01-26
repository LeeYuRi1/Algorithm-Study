package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

// 이분 그래프
public class Main_1707 {

    static private ArrayList<Integer>[] a;
    static private int[] color;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        while (k-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            a = new ArrayList[n + 1];
            color = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = new ArrayList<>();
            }
            while (m-- > 0) {
                int v = sc.nextInt();
                int e = sc.nextInt();
                a[v].add(e);
                a[e].add(v);
            }

            boolean ok = true;
            for (int i = 1; i <= n; i++) {
                if (color[i] == 0) dfs(i, 1);
            }

            //모든 정점과 간선에 대해 간선의 양 끝 점이 같으면 false, 다르면 true
            for (int i = 1; i <= n; i++) {
                for (int j : a[i]) {
                    if (color[i] == color[j]) ok = false; //한번이라도 다르면 이분그래프가 아님
                }
            }
            if (ok) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static void dfs(int x, int c) {
        color[x] = c;
        for (int y : a[x]) {
            if (color[y] == 0) dfs(y, 3 - c); // 다음 정점의 색상은 3-c가 됨 1 -> 2 -> 1
        }
    }
}
