package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2564 {
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());
        int[] d = new int[t];
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            d[i] = getDistanceNum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        int cur = getDistanceNum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        int ans = 0, len = 2 * (n + m);
        for (int i = 0; i < t; i++) {
            int diff = Math.abs(cur - d[i]);
            ans += Math.min(diff, len - diff);
        }
        System.out.println(ans);
    }

    private static int getDistanceNum(int d1, int d2) {
        if (d1 == 1) return d2;
        else if (d1 == 2) return (2 * n + m) - d2;
        else if (d1 == 3) return 2 * (n + m) - d2;
        return n + d2;
    }
}
