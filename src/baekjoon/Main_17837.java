package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Pair_17837 {
    int num;
    int x;
    int y;
    int d;

    public Pair_17837(int num, int x, int y, int d) {
        this.num = num;
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class Main_17837 {
    private static int n;
    private static int[][] color; // 체스판의 색깔
    private static List<Integer>[][] piecesNum; // 각 위치에서의 말
    private static Pair_17837[] pieces; // 각 말들의 정보
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        int k = Integer.parseInt(input1[1]);
        color = new int[n][n];
        piecesNum = new ArrayList[n][n];
        pieces = new Pair_17837[k];
        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                color[i][j] = Integer.parseInt(input2[j]); // 0: 흰색, 1: 빨간색, 2: 파란색
                piecesNum[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < k; i++) {
            String[] input3 = br.readLine().split(" ");
            int r = Integer.parseInt(input3[0]) - 1;
            int c = Integer.parseInt(input3[1]) - 1;
            int d = Integer.parseInt(input3[2]) - 1;
            piecesNum[r][c].add(i);
            pieces[i] = new Pair_17837(i, r, c, d);
        }

        int ans = 0;
        while (ans <= 1000) {
            ans++;
            for (int i = 0; i < k; i++) {
                if (move(i)) {
                    System.out.println(ans);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean move(int num) {
        Pair_17837 p = pieces[num];
        int nx = p.x + dx[p.d];
        int ny = p.y + dy[p.d];
        if (nx < 0 || nx >= n || ny < 0 || ny >= n || color[nx][ny] == 2) {
            if (p.d % 2 == 0) p.d++;
            else p.d--;
            nx = p.x + dx[p.d];
            ny = p.y + dy[p.d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || color[nx][ny] == 2) return false;
        }
        movePieces(nx, ny, p);
        return piecesNum[nx][ny].size() >= 4;
    }

    private static void movePieces(int nx, int ny, Pair_17837 p) {
        int index = getIndex(p.num, p.x, p.y);
        int x = p.x;
        int y = p.y;
        while (index < piecesNum[x][y].size()) {
            int temp = 0;
            if (color[nx][ny] == 0) { // 흰색
                temp = piecesNum[x][y].remove(index);
            } else { // 빨강
                temp = piecesNum[x][y].remove(piecesNum[x][y].size() - 1);
            }
            pieces[temp].x = nx;
            pieces[temp].y = ny;
            piecesNum[nx][ny].add(temp);
        }
    }

    private static int getIndex(int num, int x, int y) {
        for (int i = 0; i < piecesNum[x][y].size(); i++) {
            if (piecesNum[x][y].get(i) == num) return i;
        }
        return -1;
    }
}
