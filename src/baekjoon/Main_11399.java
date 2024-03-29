package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(time);
        int ans = 0;
        int wait = 0;
        for (int i = 0; i < n; i++) {
            ans += wait + time[i];
            wait += time[i];
        }
        System.out.println(ans);
    }
}
