package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소요 시간 : 167 ms
// 메모리 사용량 : 24,608 kb
public class Solution_9229 {
    private static int n, m, ans;
    private static int[] weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            weight = new int[n];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }
            ans = -1;
            combination(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void combination(int cnt, int start, int sum) {
        if (cnt == 2) {
            if (sum <= m) ans = Math.max(ans, sum);
            return;
        }
        for (int i = start; i < n; i++) {
            combination(cnt + 1, i + 1, sum + weight[i]);
        }
    }
}
