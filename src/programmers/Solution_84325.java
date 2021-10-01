package programmers;

import java.util.HashMap;

// 직업군 추천하기
public class Solution_84325 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"}, new String[]{"PYTHON", "C++", "SQL"}, new int[]{7, 5, 5}));
        System.out.println(solution(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"}, new String[]{"JAVA", "JAVASCRIPT"}, new int[]{7, 5}));
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < languages.length; i++) {
            map.put(languages[i], preference[i]);
        }
        int ans = 0;
        for (int i = 0; i < table.length; i++) {
            String[] languageScore = table[i].split(" ");
            int score = 0;
            for (int j = 1; j < languageScore.length; j++) {
                if (map.containsKey(languageScore[j])) {
                    score += map.get(languageScore[j]) * (languageScore.length - j);
                }
            }
            if (score > ans) {
                ans = score;
                answer = languageScore[0];
            }
            if (score == ans && languageScore[0].compareTo(answer) < 0) {
                answer = languageScore[0];
            }
        }
        return answer;
    }
}
