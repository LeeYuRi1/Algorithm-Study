package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최소값을 만드려면 최대한 큰 수를 빼야함 - 덧셈을 먼저 계산
public class Main_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");
        int ans = 0;
        for (int i = 0; i < input.length; i++) {
            int sum = 0;
            String[] num = input[i].split("\\+");
            for (int j = 0; j < num.length; j++) {
                sum += Integer.parseInt(num[j]);
            }
            if (i == 0) ans += sum;
            else ans -= sum;
        }
        System.out.println(ans);
    }
}
