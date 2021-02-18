package programmers.level1;

// 수박수박수박수박수박수?
public class StringPattern {
    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(4));
    }

    static public String solution(int n) {
        String answer = "";
        String str1 = "수";
        String str2 = "수박";
        for (int i = 0; i < n / 2; i++) {
            answer += str2;
        }
        if (n % 2 != 0) {
            answer += str1;
        }
        return answer;
    }
}
