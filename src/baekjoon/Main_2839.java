package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//소요 시간 : 76 ms
//메모리 사용량 : 11456 kb
public class Main_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        while (true) {
            if (n < 0) {
                ans = -1;
                break;
            }
            if (n % 5 == 0) {
                ans += n / 5;
                break;
            }
            n -= 3;
            ans++;
        }
        System.out.println(ans);
    }
}
