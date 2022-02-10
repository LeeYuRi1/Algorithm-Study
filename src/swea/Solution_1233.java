package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소요 시간 : 118 ms
// 메모리 사용량 : 19,132 kb
public class Solution_1233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String op = "+-*/";
        int ans;
        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            ans = 1;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String s = st.nextToken();
                if (!st.hasMoreTokens() && op.contains(s)) ans = 0; // 자식이 있는데 연산자가 아니라면 0
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}
