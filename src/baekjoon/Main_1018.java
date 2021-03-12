package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1018 {

    private static String[] str;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        int min = 64;
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                min = Math.min(min, find(i, j));
            }
        }
        System.out.println(min);
    }

    private static int find(int i, int j) {
        String[] chess1 = new String[]{"WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW"};
        String[] chess2 = new String[]{"BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB"};

        int count1 = 0;
        int count2 = 0;
        for (int n = 0; n < 8; n++) {
            for (int m = 0; m < 8; m++) {
                char p = str[i + n].charAt(j + m);
                if (p != chess1[n].charAt(m)) {
                    count1++;
                }
                if (p != chess2[n].charAt(m)) {
                    count2++;
                }
            }
        }
        return Math.min(count1, count2);
    }
}
