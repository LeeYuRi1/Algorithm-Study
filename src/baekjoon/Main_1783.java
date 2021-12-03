package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 높이(n)가 1인 경우 - 움직일 수 없음. 정답 1
// 2인 경우 - 두가지 방법만 사용 가능. min(4, (m+1)/2) (이동제한 때문에 4 필요)
// 3보다 크거나 같은 경우 - 7보다 크거나 같은 경우와 7보다 작은 경우로 나뉨 (4가지 방법을 모두 사용하려면 7칸이 필요함)
public class Main_1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int ans = 0;
        if (n == 1) {
            ans = 1;
        } else if (n == 2) {
            ans = Math.min(4, (m + 1) / 2);
        } else {
            if (m >= 7) ans = m - 2;
            else ans = Math.min(4, m);
        }
        System.out.println(ans);
    }
}
