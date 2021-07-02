package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1439 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split("");
        int count0 = 0; // 1을 0으로 바꾸는 경우
        int count1 = 0; // 0을 1로 바꾸는 경우
        if (s1[0].equals("1")) count0++; // 첫번째 인덱스 처리
        else count1++;
        for (int i = 0; i < s1.length - 1; i++) {
            if (!s1[i].equals(s1[i + 1])) { // i번째와 i+1번째가 다를때마다 체크
                if (s1[i + 1].equals("1")) count0++; // 0 -> 1이 되면 1을 0으로 바꿔야하므로 count0++
                else count1++;
            }
        }
        System.out.println(Math.min(count0, count1));
    }
}
