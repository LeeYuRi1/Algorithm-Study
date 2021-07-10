package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("249"));
        System.out.println(letterCombinations(""));
    }

    public static List<String> letterCombinations(String digits) {
        String[][] s = {
                {"a", "b", "c", ""},
                {"d", "e", "f", ""},
                {"g", "h", "i", ""},
                {"j", "k", "l", ""},
                {"m", "n", "o", ""},
                {"p", "q", "r", "s"},
                {"t", "u", "v", ""},
                {"w", "x", "y", "z"}};
        List<String> ans = new ArrayList<>();
        if (digits.equals("")) {
            return ans;
        }
        String[][] strings = new String[digits.length()][4];
        for (int i = 0; i < digits.length(); i++) {
            for (int j = 0; j < 4; j++) {
                int n = digits.charAt(i) - '0';
                strings[i][j] = s[n - 2][j];
            }
        }
        int[] arr = new int[digits.length()];
        dfs(strings, arr, ans, 0, digits.length());
        return ans;
    }

    private static void dfs(String[][] strings, int[] arr, List<String> ans, int depth, int len) {
        if (depth == len) {
            String result = "";
            for (int i = 0; i < arr.length; i++) {
                String s = strings[i][arr[i]];
                if (s.equals("")) return;
                result += s;
            }
            ans.add(result);
            return;
        }
        for (int i = 0; i < 4; i++) {
            arr[depth] = i;
            dfs(strings, arr, ans, depth + 1, len);
        }
    }
}
