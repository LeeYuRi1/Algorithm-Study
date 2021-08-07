package template.graph;

// 플로이드 (예제 설명: 백준 11403, 11404)
// 시간복잡도: O(V^3)
// 모든 쌍의 최단 경로를 구하는 알고리즘
public class FloydWarshall {
    public static void main(String[] args) {
        int n = 3;
        int inf = 1000000;
        int[][] g = {{inf, 1, inf}, {inf, inf, 1}, {1, inf, inf}}; // 0이면 무한대로 놓기

        // i에서 j까지 갈때 k를 거쳐서 가는게 더 빠르면 값 변경
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (g[i][j] > g[i][k] + g[k][j]) {
                        g[i][j] = g[i][k] + g[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == inf || i == j) sb.append("0 ");
                else sb.append(g[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
