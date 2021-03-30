package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        int team = 0;
        if (n / 2 > m) team = m;
        else team = n / 2;
        n -= team * 2;
        m -= team;

        if (k > n + m) {
            k -= n + m;
            team = ((3 * team) - k) / 3;
        }
        System.out.println(team);
    }
}
