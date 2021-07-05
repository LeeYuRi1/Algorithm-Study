package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최소값을 만드려면 최대한 큰 수를 빼야함 - 덧셈을 먼저 계산
public class Main_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");
        int[] num = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            int n = 0;
            String[] s = input[i].split("\\+");
            for (int j = 0; j < s.length; j++) {
                n += Integer.parseInt(s[j]);
            }
            num[i] = n;
        }
        int result = num[0];
        for (int i = 1; i < num.length; i++) {
            result -= num[i];
        }
        System.out.println(result);
    }
}
