package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Quadrangle implements Comparable<Quadrangle> {
    int x;
    int y;
    int p;
    int q;

    public Quadrangle(int x, int y, int p, int q) {
        this.x = x;
        this.y = y;
        this.p = p;
        this.q = q;
    }

    @Override
    public int compareTo(Quadrangle o) {
        return this.x - o.x;
    }
}

public class Main_2527 {
    private static Quadrangle[] quads;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            quads = new Quadrangle[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            quads[0] = new Quadrangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            quads[1] = new Quadrangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Arrays.sort(quads);
            System.out.println(getCode());
        }
    }

    private static String getCode() {
        Quadrangle q1 = quads[0];
        Quadrangle q2 = quads[1];
        if (q1.p == q2.x && (q1.y == q2.q || q1.q == q2.y)) return "c"; // 점
        if (q1.y > q2.q || q1.q < q2.y || q1.p < q2.x) return "d"; // 공통부분이 없음
        if (q1.y == q2.q || q1.q == q2.y || q1.p == q2.x) return "b"; // 선분
        return "a"; // 직사각형
    }
}