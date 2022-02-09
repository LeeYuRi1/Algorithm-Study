package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소요 시간 : 115 ms
// 메모리 사용량 : 24,348 kb
public class Solution_3499 {
    private static int n;
    private static String[] card;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            card = br.readLine().split(" ");
            sb.append("#").append(tc).append(" ");
            perfectShuffle();
        }
        System.out.println(sb);
    }

    private static void perfectShuffle() {
        int half = n % 2 == 0 ? n / 2 : n / 2 + 1;
        for (int i = 0; i < n / 2; i++) {
            sb.append(card[i]).append(" ").append(card[i + half]).append(" ");
        }
        if (n % 2 != 0) sb.append(card[half - 1]);
        sb.append("\n");
    }
}
