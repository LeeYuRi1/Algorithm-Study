package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 플러드 필
// 연결요소를 찾는 것과 유사
// d[i][j] = (i, j)를 방문안했으면 0, 했으면 단지 번호
class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_2667 {

    static private int[][] a;
    static private int[][] d;
    static private int[] dx = {0, 0, 1, -1};
    static private int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        int cnt = 0;
        d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1 && d[i][j] == 0) // 정점이고 아직 방문하지 않으면 bfs 호출
                    bfs(i, j, ++cnt, n);
            }
        }

        int[] ans = new int[cnt];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] != 0) {
                    ans[d[i][j] - 1] += 1;
                }
            }
        }

        System.out.println(cnt);
        Arrays.sort(ans);
        for (int i = 0; i < cnt; i++) {
            System.out.println(ans[i]);
        }
    }

    // dfs를 이용해도 가능
    private static void bfs(int x, int y, int cnt, int n) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        d[x][y] = cnt;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            x = p.x;
            y = p.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) { //범위 안에 들어가는지 검사
                    if (a[nx][ny] == 1 && d[nx][ny] == 0) { // 간선이 있는지, 그 칸을 방문하지 않았는지 검사
                        q.add(new Pair(nx, ny));
                        d[nx][ny] = cnt;
                    }
                }
            }
        }
    }
}
