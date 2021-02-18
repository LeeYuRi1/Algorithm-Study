package programmers.level1;

import java.util.Arrays;

// 서울에서 김서방 찾기
public class FindKimInSeoul {
    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};
        System.out.println(solution(seoul));
    }

    static public String solution(String[] seoul) {
        int n = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 " + n + "에 있다";
    }
}
