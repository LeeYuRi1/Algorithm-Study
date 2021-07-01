package programmers;

// 신규 아이디 추천
public class Solution_72410 {
    public static void main(String[] args) {
        System.out.println(solution("=.="));
        System.out.println(solution2("...!@BaT#*..y.abcdefghijklm"));
    }

    // 내 풀이 - 노가다
    public static String solution(String new_id) {
        String answer = "";
        // 1
        answer = new_id.toLowerCase();

        // 2
        for (int i = 0; i < answer.length(); i++) {
            char c = answer.charAt(i);
            if (!Character.isLowerCase(c) && !Character.isDigit(c) && c != '-' && c != '_' && c != '.') {
                answer = answer.replace(c, ' ');
            }
        }
        answer = answer.replace(" ", "");

        // 3
        String answer2 = "";
        for (int i = 0; i < answer.length(); i++) {
            char c = answer.charAt(i);
            if (i == 0) answer2 += c;
            if (i > 0) {
                if (c != '.' || answer2.charAt(answer2.length() - 1) != '.') {
                    answer2 += c;
                }
            }
        }
        answer = answer2;

        // 4
        while (!answer.isEmpty() && answer.charAt(0) == '.') {
            if (answer.length() == 1) {
                answer = "";
            } else {
                answer = answer.substring(1);
            }
        }
        while (!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.') {
            if (answer.length() == 1) {
                answer = "";
            } else {
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        // 5
        if (answer.length() == 0) {
            answer = "a";
        }

        // 6
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if (answer.charAt(14) == '.') {
                answer = answer.substring(0, 14);
            }
        }

        // 7
        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }

        return answer;
    }


    // 다른사람 풀이 참고 - 정규식 사용
    public static String solution2(String new_id) {
        String answer = "";
        // 1
        answer = new_id.toLowerCase();

        // 2
        answer = answer.replaceAll("[^-_.a-z0-9]", "");

        // 3
        answer = answer.replaceAll("[.]{2,}", ".");

        // 4
        answer = answer.replaceAll("^[.]|[.]$", "");

        // 5
        if (answer.length() == 0) {
            answer = "a";
        }

        // 6
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if (answer.charAt(14) == '.') {
                answer = answer.substring(0, 14);
            }
        }

        // 7
        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }

        return answer;
    }
}
