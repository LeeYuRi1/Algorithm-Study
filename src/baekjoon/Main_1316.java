package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1316 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while (n-- > 0) {
            String s = br.readLine();
            if (groupWord(s)) count++;
        }
        System.out.println(count);
    }

    private static boolean groupWord(String s) {
        String word = "";
        for (int i = 0; i < s.length(); i++) {
            String w = s.charAt(i) + "";
            if (word.contains(w)) {
                if (!(word.charAt(word.length() - 1) + "").equals(w)) {
                    return false;
                }
            } else {
                word += w;
            }
        }
        return true;
    }
}
