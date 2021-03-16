package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1205 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int newScore = Integer.parseInt(input[1]);
        int p = Integer.parseInt(input[2]);
        if (n == 0) {
            System.out.println(1);
            return;
        }

        String[] scores = br.readLine().split(" ");
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = Integer.parseInt(scores[i]);
        }

        if (n == p && newScore <= rank[p - 1]) {
            System.out.println(-1);
            return;
        }

        int rankNum = 0;
        int rankScore = 2000000001;
        int same = 1;
        for (int i = 0; i < n; i++) {
            if (rank[i] < rankScore) {
                rankScore = rank[i];
                rankNum += same;
                same = 1;
            } else if (rank[i] == rankScore) {
                same++;
            }
            if (newScore >= rank[i]) {
                System.out.println(rankNum);
                return;
            }
        }
        System.out.println(rankNum+same);
    }
}
