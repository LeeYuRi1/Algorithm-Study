package template.graph;

import java.util.ArrayList;

// 시작 정점 1개에서 연결된 모든 정점을 dfs로 탐색
public class Dfs_1 {
    public static void main(String[] args) {
        int n = 4;
        // 인접행렬
        int[][] a1 = new int[n + 1][n + 1];
        a1[1][2] = a1[2][1] = 1;
        a1[1][3] = a1[3][1] = 1;
        a1[1][4] = a1[4][1] = 1;
        a1[2][4] = a1[4][2] = 1;
        a1[3][4] = a1[4][3] = 1;

        // 인접리스트
        ArrayList<Integer>[] a2 = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            a2[i] = new ArrayList<>();
        }
        a2[1].add(2);
        a2[2].add(1); // 양방향 그래프
        a2[1].add(3);
        a2[3].add(1);
        a2[1].add(4);
        a2[4].add(1);
        a2[2].add(4);
        a2[4].add(2);
        a2[3].add(4);
        a2[4].add(3);

        boolean[] check = new boolean[n + 1];
        dfs1(a1, check, 1, n);
        System.out.println();

        check = new boolean[n + 1];
        dfs2(a2, check, 1);
    }

    // 인접 행렬
    private static void dfs1(int[][] a1, boolean[] check, int x, int n) {
        check[x] = true;
        System.out.print(x + " ");
        for (int y = 1; y <= n; y++) {
            if (!check[y] && a1[x][y] == 1) { // 방문하지 않았고 간선이 있을 때
                dfs1(a1, check, y, n);
            }
        }
    }

    // 인접 리스트
    private static void dfs2(ArrayList<Integer>[] a2, boolean[] check, int x) {
        check[x] = true;
        System.out.print(x + " ");
        for (int y : a2[x]) {
            if (!check[y]) { // 방문하지 않았을 때
                dfs2(a2, check, y);
            }
        }
    }
}
