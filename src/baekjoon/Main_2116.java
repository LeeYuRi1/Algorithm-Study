package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2116 {
    private static int dice[][];
    private static int[] bottomIdx = {5, 3, 4, 1, 2, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dice = new int[n][6];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0, top, bottom, sum;
        for (int i = 1; i <= 6; i++) {
            bottom = i;
            sum = 0;
            for (int j = 0; j < n; j++) {
                top = getTopIndex(j, bottom); // 이전의 bottom값으로 top의 인덱스를 찾아옴
                sum += setDice(j, top, bottomIdx[top]); // 두개 빼고 최대값 찾아서 더함
                bottom = dice[j][bottomIdx[top]]; // 현재 bottom값으로 바꿈
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }

    private static int setDice(int i, int top, int bottom) {
        int max = 0;
        for (int j = 0; j < 6; j++) {
            if (j == top || j == bottom) continue;
            max = Math.max(max, dice[i][j]);
        }
        return max;
    }

    private static int getTopIndex(int i, int top) {
        for (int j = 0; j < 6; j++) {
            if (dice[i][j] == top) return j;
        }
        return 0;
    }
}
