package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//소요 시간 : 240 ms
//메모리 사용량 : 48,948 kb
public class Solution_4012 {
    private static int N, arr[][], ans;
    private static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            isSelected = new boolean[N];
            ans = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            combination(0, 0);
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void combination(int cnt, int start) {
        if (cnt == N / 2) {
            List<Integer> temp1 = new ArrayList<>();
            List<Integer> temp2 = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) temp1.add(i);
                else temp2.add(i);
            }
            ans = Math.min(ans, Math.abs(getSum(temp1) - getSum(temp2)));
            return;
        }
        for (int i = start; i < N; i++) {
            isSelected[i] = true;
            combination(cnt + 1, i + 1);
            isSelected[i] = false;
        }
    }

    private static int getSum(List<Integer> temp) {
        int sum = 0;
        for (int i = 0; i < N / 2 - 1; i++) {
            for (int j = i + 1; j < N / 2; j++) {
                int a = temp.get(i);
                int b = temp.get(j);
                sum += arr[a][b] + arr[b][a];
            }
        }
        return sum;
    }
}