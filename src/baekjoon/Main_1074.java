package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//소요 시간 : 80 ms
//메모리 사용량 : 11516 kb
public class Main_1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        findNum(1 << N, r, c, 0);
    }

    private static void findNum(int n, int x, int y, int count) {
        if (n == 1) {
            System.out.println(count);
            return;
        }
        boolean top = (x < n / 2) ? true : false;
        boolean left = (y < n / 2) ? true : false;

        int m = n * n / 4;
        if (top && left) findNum(n / 2, x, y, count);
        else if (top && !left) findNum(n / 2, x, y - n / 2, count + m);
        else if (!top && left) findNum(n / 2, x - n / 2, y, count + 2 * m);
        else findNum(n / 2, x - n / 2, y - n / 2, count + 3 * m);
    }
}
