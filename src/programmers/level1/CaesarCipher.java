package programmers.level1;

// 시저 암호
public class CaesarCipher {
    public static void main(String[] args) {
        System.out.println(solution("AB", 1));
        System.out.println(solution("z", 1));
        System.out.println(solution("a B z", 4));
    }

    static public String solution(String s, int n) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i);
            if (value != ' ') {
                if (value < 'a') {
                    value = value - 'A';
                    answer += (char) ((value + n) % 26 + 'A');
                } else {
                    value = value - 'a';
                    answer += (char) ((value + n) % 26 + 'a');
                }
            } else {
                answer += " ";
            }
        }
        return answer;
    }
}
