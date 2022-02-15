package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244 {
    private static int n, switchs[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        switchs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            switchs[i] = Integer.parseInt(st.nextToken());
        }
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1) boy(b);
            else girl(b);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(switchs[i]).append(" ");
            if (i % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void boy(int x) {
        int index = x;
        while (index <= n) {
            switchs[index] = switchs[index] == 0 ? 1 : 0;
            index += x; // 배수일 때 +로 해야함! *2 하지 않도록 조심
        }
    }

    private static void girl(int x) {
        int left = x - 1;
        int right = x + 1;
        switchs[x] = switchs[x] == 0 ? 1 : 0;
        while ((left >= 1 && right <= n) && (switchs[left] == switchs[right])) {
            switchs[left] = switchs[left] == 0 ? 1 : 0;
            switchs[right] = switchs[right] == 0 ? 1 : 0;
            left--;
            right++;
        }
    }
}
