package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소요 시간 : 183 ms
// 메모리 사용량 : 20,424 kb
public class Solution_5215 {
    private static int n, l, ans;
    private static int[] taste;
    private static int[] calorie;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            taste = new int[n];
            calorie = new int[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                taste[i] = Integer.parseInt(st.nextToken());
                calorie[i] = Integer.parseInt(st.nextToken());
            }
            ans = 0;
            select(0, 0, 0);
            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    private static void select(int cnt, int sumT, int sumC) {
        if (sumC > l) return;
        else ans = Math.max(ans, sumT);
        if (cnt == n) return;
        select(cnt + 1, sumT + taste[cnt], sumC + calorie[cnt]);
        select(cnt + 1, sumT, sumC);
    }
}
