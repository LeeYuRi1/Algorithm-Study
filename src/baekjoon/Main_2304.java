package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Stick implements Comparable<Stick> {
    int index;
    int h;

    public Stick(int index, int h) {
        this.index = index;
        this.h = h;
    }

    @Override
    public int compareTo(Stick o) {
        return this.index - o.index;
    }
}

public class Main_2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Stick[] sticks = new Stick[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            sticks[i] = new Stick(l, h);
        }
        Arrays.sort(sticks);
        int ans = 0;
        // 왼쪽에서 오른쪽
        Stick cur1 = sticks[0];
        for (int i = 1; i < n; i++) {
            if (cur1.h < sticks[i].h) {
                ans += (sticks[i].index - cur1.index) * cur1.h;
                cur1 = sticks[i];
            }
        }
        // 오른쪽에서 왼쪽
        Stick cur2 = sticks[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (cur2.h < sticks[i].h) {
                ans += (cur2.index - sticks[i].index) * cur2.h;
                cur2 = sticks[i];
            }
        }
        // 높이가 제일 큰 기둥
        ans += (cur2.index - cur1.index + 1) * cur1.h;
        System.out.println(ans);
    }
}