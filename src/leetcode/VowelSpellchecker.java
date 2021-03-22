package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VowelSpellchecker {
    public static void main(String[] args) {
        String[] answer = spellchecker(new String[]{"KiTe", "kite", "hare", "Hare"}, new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"});
        for (String s : answer) {
            System.out.println(s);
        }
    }

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        List<String> word = Arrays.asList(wordlist);
        List<String> wordUppercase = new ArrayList<>();
        List<String> wordReplace = new ArrayList<>();
        for (int i = 0; i < wordlist.length; i++) {
            wordUppercase.add(word.get(i).toUpperCase());
            wordReplace.add(word.get(i).toUpperCase().replaceAll("[AEIOU]", "0"));
        }
        String[] answer = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String result = "";
            if (word.contains(queries[i])) {
                int index = word.indexOf(queries[i]);
                result = word.get(index);
            }
            if (result.equals("")) {
                String s = queries[i].toUpperCase();
                if (wordUppercase.contains(s)) {
                    int index = wordUppercase.indexOf(s);
                    result = word.get(index);
                }
            }
            if (result.equals("")) {
                String s = queries[i].toUpperCase().replaceAll("[AEIOU]", "0");
                if (wordReplace.contains(s)) {
                    int index = wordReplace.indexOf(s);
                    result = word.get(index);
                }
            }
            answer[i] = result;
        }
        return answer;
    }
}
