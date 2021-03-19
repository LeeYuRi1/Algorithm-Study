package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2775 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(indwellerNum(k, n));
        }
    }

    private static int indwellerNum(int a, int b) {
        int result = 0;
        int[][] num = new int[a + 1][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (i == 0) {
                    num[i][j] = j + 1;
                } else {
                    for (int k = 0; k <= j; k++) {
                        num[i][j] += num[i - 1][k];
                    }
                }
            }
        }
        for (int i = 0; i < b; i++) {
            result += num[a - 1][i];
        }
        return result;
    }
}
