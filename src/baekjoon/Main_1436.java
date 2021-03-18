package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1436 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = 666;
        int result = 0;
        while (true) {
            String s = num + "";
            boolean check = false;
            if (s.contains("666")) check = true;
            if (check) result++;
            if (n == result) break;
            num++;
        }
        System.out.println(num);
    }
}
