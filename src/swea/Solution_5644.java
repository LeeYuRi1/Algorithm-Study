package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//소요 시간 : 129 ms
//메모리 사용량 : 24,104 kb
public class Solution_5644 {
    private static int A, bc[][];
    private static int[] dx = {0, -1, 0, 1, 0};
    private static int[] dy = {0, 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 총 이동 시간
            A = Integer.parseInt(st.nextToken()); // BC의 개수
            // 사용자 a,b의 이동 정보
            int[][] ab = new int[2][M + 1];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= M; j++) {
                    ab[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // BC 정보
            bc = new int[A][4];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                bc[i][1] = Integer.parseInt(st.nextToken()) - 1;
                bc[i][0] = Integer.parseInt(st.nextToken()) - 1;
                bc[i][2] = Integer.parseInt(st.nextToken());
                bc[i][3] = Integer.parseInt(st.nextToken());
            }
            int ans = 0, ax = 0, ay = 0, bx = 9, by = 9;
            for (int i = 0; i <= M; i++) {
                ax += dx[ab[0][i]];
                ay += dy[ab[0][i]];
                bx += dx[ab[1][i]];
                by += dy[ab[1][i]];
                ans += step(ax, ay, bx, by);
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static int step(int ax, int ay, int bx, int by) {
        int[] arrA = new int[A];
        int[] arrB = new int[A];
        for (int i = 0; i < A; i++) {
            arrA[i] = check(ax, ay, i);
            arrB[i] = check(bx, by, i);
        }
        int maxP = 0;
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                int a = arrA[i];
                int b = arrB[j];
                int sum = a + b;
                if (i == j && a == b) sum /= 2;
                maxP = Math.max(maxP, sum);
            }
        }
        return maxP;
    }

    private static int check(int x, int y, int bcn) {
        int d = Math.abs(x - bc[bcn][0]) + Math.abs(y - bc[bcn][1]);
        return d <= bc[bcn][2] ? bc[bcn][3] : 0;
    }
}
