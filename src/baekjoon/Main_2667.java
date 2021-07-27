package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 플러드 필
// 연결요소를 찾는 것과 유사
class Pair_2667 {
    int x;
    int y;

    Pair_2667(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_2667 {

    static private int[][] a;
    static private boolean[][] check;
    static private int[] dx = {0, 0, 1, -1};
    static private int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        check = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(s[j]);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1 && !check[i][j]) { // 정점이고 아직 방문하지 않으면 bfs 호출
                    ans.add(bfs(i, j, n));
                }
            }
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for (int i : ans) System.out.println(i);
    }

    private static int bfs(int x, int y, int n) {
        Queue<Pair_2667> q = new LinkedList<>();
        q.offer(new Pair_2667(x, y));
        check[x][y] = true;
        int count = 1;
        while (!q.isEmpty()) {
            Pair_2667 p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue; //범위를 벗어난다면 넘어가기
                if (a[nx][ny] == 0 || check[nx][ny]) continue; // 간선이 없거나 이미 방문했다면 넘어가기
                q.add(new Pair_2667(nx, ny));
                check[nx][ny] = true;
                count++;
            }
        }
        return count;
    }
}
