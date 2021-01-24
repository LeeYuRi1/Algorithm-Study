package programmers.level1;

import java.util.HashMap;

public class UnfinishedPlayer {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }

    static private String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            map.put(s, map.get(s) - 1);
        }

        for (String s : map.keySet()) {
            if (map.get(s) != 0)
                answer = s;
        }
        return answer;
    }
}
