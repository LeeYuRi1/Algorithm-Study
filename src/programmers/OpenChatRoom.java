package programmers;

import java.util.ArrayList;
import java.util.HashMap;

// 오픈채팅방
public class OpenChatRoom {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"}));
    }

    public static String[] solution(String[] record) {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<String> uidList = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < record.length; i++) {
            String[] s = record[i].split(" ");
            switch (s[0]) {
                case "Enter":
                    map.put(s[1], s[2]);
                    stringList.add("님이 들어왔습니다.");
                    uidList.add(s[1]);
                    break;
                case "Leave":
                    stringList.add("님이 나갔습니다.");
                    uidList.add(s[1]);
                    break;
                case "Change":
                    map.put(s[1], s[2]);
                    break;
            }
        }
        String[] answer = new String[stringList.size()];
        for (int i = 0; i < stringList.size(); i++) {
            answer[i] = map.get(uidList.get(i)) + stringList.get(i);
        }
        return answer;
    }
}
