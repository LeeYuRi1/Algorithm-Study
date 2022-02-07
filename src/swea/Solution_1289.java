package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소요 시간 : 103 ms
// 메모리 사용량 : 19,360 kb
class Solution_1289 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= t; testCase++) {
            String input = br.readLine();
            char prev = '0';
            int count = 0;
            for (char bit : input.toCharArray()) {
                if (bit != prev) {
                    count++;
                    prev = bit;
                }
            }
            sb.append("#" + testCase + " " + count + "\n");
        }
        System.out.println(sb);
    }
}