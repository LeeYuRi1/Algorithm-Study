package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int max = 0;
        int min = 0;
        while (st.hasMoreTokens()) {
            int token = Integer.parseInt(st.nextToken());
            if (max == 0 && min == 0) {
                max = token;
                min = token;
            } else {
                if (token > max) max = token;
                if (token < min) min = token;
            }
        }
        System.out.println(min + " " + max);
    }
}
