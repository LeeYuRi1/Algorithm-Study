package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main_1063 {
    public static void main(String[] args) throws Exception {
        String[] move = new String[]{"R", "L", "B", "T", "RT", "LT", "RB", "LB"};
        List<String> moveList = Arrays.asList(move);
        int[] x = new int[]{1, -1, 0, 0, 1, -1, 1, -1};
        int[] y = new int[]{0, 0, -1, 1, 1, 1, -1, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int kingX = input[0].charAt(0) - '0' - 16;
        int kingY = input[0].charAt(1) - '0';
        int stoneX = input[1].charAt(0) - '0' - 16;
        int stoneY = input[1].charAt(1) - '0';

        for (int i = 0; i < Integer.parseInt(input[2]); i++) {
            String s = br.readLine();
            int index = moveList.indexOf(s);
            if (kingX + x[index] > 0 && kingX + x[index] < 9 && kingY + y[index] > 0 && kingY + y[index] < 9) {
                if (kingX + x[index] == stoneX && kingY + y[index] == stoneY) {
                    if (stoneX + x[index] > 0 && stoneX + x[index] < 9 && stoneY + y[index] > 0 && stoneY + y[index] < 9) {
                        stoneX = stoneX + x[index];
                        stoneY = stoneY + y[index];
                        kingX = kingX + x[index];
                        kingY = kingY + y[index];
                    }

                } else {
                    kingX = kingX + x[index];
                    kingY = kingY + y[index];
                }
            }
        }
        System.out.print((char) (kingX + '0' + 16) + "" + kingY + " ");
        System.out.print((char) (stoneX + '0' + 16) + "" + stoneY);
    }
}
