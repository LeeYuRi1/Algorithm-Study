package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//소요 시간 : 320 ms
//메모리 사용량 : 40772 kb
class Cctv {
    int x;
    int y;
    int num;

    public Cctv(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}

public class Main_15683 {
    private static int N, M, ans = Integer.MAX_VALUE, zeroSum = 0, sum;
    private static int area[][], dir[];
    private static boolean[][] visited;
    private static List<Cctv> cctvList = new ArrayList<>();
    private static int[] dx = {-1, 0, 1, 0}; // 상좌하우
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        area = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (area[i][j] == 0) zeroSum++;
                else if (area[i][j] < 6) cctvList.add(new Cctv(i, j, area[i][j]));
            }
        }
        dir = new int[cctvList.size()];
        permutation(0);
        System.out.println(ans);
    }

    private static void permutation(int cnt) {
        if (cnt == cctvList.size()) {
            visited = new boolean[N][M];
            int count = 0;
            for (int i = 0; i < cctvList.size(); i++) {
                count += getArea(cctvList.get(i), dir[i]);
            }
            ans = Math.min(ans, zeroSum - count);
            return;
        }
        for (int i = 0; i < 4; i++) {
            dir[cnt] = i;
            permutation(cnt + 1);
        }
    }

    private static int getArea(Cctv cctv, int d) {
        sum = 0;
        switch (cctv.num) {
            case 1:
                check(cctv, d);
                break;
            case 2:
                check(cctv, d);
                check(cctv, (d + 2) % 4);
                break;
            case 3:
                check(cctv, d);
                check(cctv, (d + 1) % 4);
                break;
            case 4:
                check(cctv, d);
                check(cctv, (d + 1) % 4);
                check(cctv, (d + 3) % 4);
                break;
            case 5:
                check(cctv, 0);
                check(cctv, 1);
                check(cctv, 2);
                check(cctv, 3);
                break;
        }
        return sum;
    }

    private static void check(Cctv cctv, int d) {
        int x = cctv.x;
        int y = cctv.y;
        int count = 0;
        while (true) {
            x += dx[d];
            y += dy[d];
            if (x < 0 || x >= N || y < 0 || y >= M || area[x][y] == 6) break;
            if (visited[x][y]) continue;
            if (area[x][y] == 0) count++;
            visited[x][y] = true;
        }
        sum += count;
    }
}
