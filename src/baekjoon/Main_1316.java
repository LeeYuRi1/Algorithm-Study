package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        while (n-- > 0) {
            if (check(br.readLine())) ans++;
        }
        System.out.println(ans);
    }

    private static boolean check(String str) {
        HashSet<Character> set = new HashSet<>();
        set.add(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char prev = str.charAt(i - 1);
            char cur = str.charAt(i);
            if (prev != cur && set.contains(cur)) return false; // 이전이랑 다르고 이미 나왔었다면 그룹단어가 아님
            set.add(cur);
        }
        return true;
    }
}