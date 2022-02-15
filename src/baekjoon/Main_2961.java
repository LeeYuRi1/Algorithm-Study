package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//소요 시간 : 80 ms
//메모리 사용량 : 11516 kb
public class Main_2961 {
    private static int n, s[], b[], ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n];
        b = new int[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        subset(0, 1, 0);
        System.out.println(ans);
    }

    private static void subset(int cnt, int mulS, int sumB) {
        if (cnt == n) {
            if (sumB != 0) ans = Math.min(ans, Math.abs(mulS - sumB));
            return;
        }
        subset(cnt + 1, mulS, sumB);
        subset(cnt + 1, mulS * s[cnt], sumB + b[cnt]);
    }
}
