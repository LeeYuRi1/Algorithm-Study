package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_2217 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> ropes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ropes.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(ropes, Collections.reverseOrder());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int w = ropes.get(i) * (i+1);
            if (w > ans) ans = w;
        }
        System.out.println(ans);
    }
}
