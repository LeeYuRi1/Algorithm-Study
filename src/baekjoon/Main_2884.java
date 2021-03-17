package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2884 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int h = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]) - 45;
        if (m < 0) {
            m += 60;
            h -= 1;
            if (h < 0) h = 23;
        }
        System.out.println(h + " " + m);
    }
}
