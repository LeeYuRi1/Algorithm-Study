package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//소요 시간 : 76 ms
//메모리 사용량 : 11536 kb
public class Main_2961_2 {
    private static int n, s[], b[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n];
        b = new int[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(subset());
    }

    private static int subset() {
        int ans = Integer.MAX_VALUE;
        for (int flag = 1; flag < (1 << n); flag++) {
            int mulS = 1;
            int sumB = 0;
            for (int i = 0; i < n; i++) {
                if ((flag & 1 << i) == 0) continue;
                mulS *= s[i];
                sumB += b[i];
            }
            ans = Math.min(ans, Math.abs(mulS - sumB));
        }
        return ans;
    }
}
