package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            if (m == 1) one++;
            else if (m > 0) plus.add(m);
            else if (m < 0) minus.add(m);
            else zero++;
        }
        if (plus.size() % 2 == 1) plus.add(1);
        if (minus.size() % 2 == 1) minus.add(zero > 0 ? 0 : 1);
        Collections.sort(plus);
        Collections.sort(minus, Collections.reverseOrder());

        int ans = one;
        for (int i = 0; i < plus.size(); i += 2) {
            ans += plus.get(i) * plus.get(i + 1);
        }
        for (int i = 0; i < minus.size(); i += 2) {
            ans += minus.get(i) * minus.get(i + 1);
        }
        System.out.println(ans);
    }
}
