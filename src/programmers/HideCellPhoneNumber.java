package programmers;

// 핸드폰 번호 가리기
public class HideCellPhoneNumber {
    public static void main(String[] args) {
        System.out.println(solution("01033334444"));
        System.out.println(solution("027778888"));
    }

    public static String solution(String phone_number) {
        String answer = "";
        int n = phone_number.length() - 4;
        for (int i = 0; i < n; i++) {
            answer += "*";
        }
        answer += phone_number.substring(n);
        return answer;
    }
}
