package template.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs_1 {
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
        bfs1(a1, check, 1, n);
        System.out.println();

        check = new boolean[n + 1];
        bfs2(a2, check, 1);
    }

    // 인접 행렬
    private static void bfs1(int[][] a1, boolean[] check, int x, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        check[x] = true;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            System.out.print(p + " ");
            for (int y = 1; y <= n; y++) {
                if (!check[y] && a1[p][y] == 1) { // 방문하지 않았고 간선이 있을 때
                    queue.add(y);
                    check[y] = true;
                }
            }
        }
    }

    // 인접 리스트
    private static void bfs2(ArrayList<Integer>[] a2, boolean[] check, int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        check[x] = true;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            System.out.print(p + " ");
            for (int y : a2[p]) {
                if (!check[y]) { // 방문하지 않았을 때
                    queue.add(y);
                    check[y] = true;
                }
            }
        }
    }
}
