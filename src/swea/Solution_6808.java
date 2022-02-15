package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 소요 시간 : 916 ms
// 메모리 사용량 : 23,948 kb
public class Solution_6808 {
    private static int N = 18, win, lose;
    private static int card1[], card2[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        card1 = new int[N / 2];
        card2 = new int[N / 2];
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            boolean[] isSelected = new boolean[N + 1];
            for (int i = 0; i < N / 2; i++) {
                card1[i] = Integer.parseInt(st.nextToken());
                isSelected[card1[i]] = true;
            }
            int index = 0;
            for (int i = 1; i <= N; i++) {
                if (!isSelected[i]) card2[index++] = i;
            }
            Arrays.sort(card2);
            win = 0;
            lose = 0;
            do {
                play();
            } while (np());
            sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean np() {
        int i = N / 2 - 1;
        while (i > 0 && card2[i - 1] >= card2[i]) --i;
        if (i == 0) return false;

        int j = N / 2 - 1;
        while (card2[i - 1] >= card2[j]) --j;

        swap(i - 1, j);

        int k = N / 2 - 1;
        while (i < k) swap(i++, k--);
        return true;
    }

    private static void swap(int i, int j) {
        int temp = card2[i];
        card2[i] = card2[j];
        card2[j] = temp;
    }

    private static void play() {
        int score1 = 0;
        int score2 = 0;
        for (int i = 0; i < N / 2; i++) {
            int sum = card1[i] + card2[i];
            if (card1[i] > card2[i]) score1 += sum;
            else score2 += sum;
        }
        if (score1 > score2) win++;
        else lose++;
    }
}
