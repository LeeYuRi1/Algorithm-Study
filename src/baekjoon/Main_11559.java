package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair_11559 {
    int x;
    int y;
    String color;

    public Pair_11559(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}

public class Main_11559 {
    private static int n = 12;
    private static int m = 6;
    private static String[][] field = new String[n][m];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                field[i][j] = s[j];
            }
        }

        int ans = 0;
        boolean check = true;
        while (check) {
            check = find();
            if (check) {
                ans++;
                fall();
            }
        }
        System.out.println(ans);
    }

    // .이 아닌 뿌요가 나오면 bfs 호출
    private static boolean find() {
        boolean result = false;
        Queue<Pair_11559> queue = new LinkedList<>();
        boolean[][] check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (field[i][j].equals(".") || check[i][j]) continue;
                queue.offer(new Pair_11559(i, j, field[i][j]));
                check[i][j] = true;
                if (bfs(queue, check)) result = true;
            }
        }
        return result;
    }

    // 같은 색깔의 뿌요가 4개 이상이면 터짐
    private static boolean bfs(Queue<Pair_11559> queue, boolean[][] check) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int count = 1;
        boolean result = false;
        ArrayList<Pair_11559> a = new ArrayList<>();
        while (!queue.isEmpty()) {
            Pair_11559 p = queue.poll();
            a.add(new Pair_11559(p.x, p.y, field[p.x][p.y]));
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (check[nx][ny] || !field[nx][ny].equals(p.color)) continue;
                check[nx][ny] = true;
                queue.offer(new Pair_11559(nx, ny, field[nx][ny]));
                count++;
            }
        }
        if (count >= 4) {
            result = true;
            for (int i = 0; i < a.size(); i++) {
                Pair_11559 p = a.get(i);
                field[p.x][p.y] = ".";
            }
        }
        return result;
    }

    // 한 그룹이라도 터지면 밑으로 떨어짐
    private static void fall() {
        Queue<String> queue = new LinkedList<>();
        for (int j = 0; j < m; j++) {
            // 새로마다 뿌요들을 큐에 담음
            for (int i = n - 1; i >= 0; i--) {
                if (!field[i][j].equals(".")) queue.offer(field[i][j]);
            }
            // 아래부터 채움
            for (int i = n - 1; i >= 0; i--) {
                if (!queue.isEmpty()) field[i][j] = queue.poll();
                else field[i][j] = ".";
            }
        }
    }
}
