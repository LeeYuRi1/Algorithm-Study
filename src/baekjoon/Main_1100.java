package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1100 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        for (int i = 0; i < 8; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < str.length; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0 && str[j].equals("F")) count++;
                } else {
                    if (j % 2 != 0 && str[j].equals("F")) count++;
                }
            }
        }
        System.out.println(count);
    }
}
