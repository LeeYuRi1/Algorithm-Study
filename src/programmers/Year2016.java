package programmers;

// 2016년
public class Year2016 {
    public static void main(String[] args) {
        System.out.println(solution(1, 1));
        System.out.println(solution(5, 24));
    }

    public static String solution(int a, int b) {
        String answer = "";
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int sum = 0;
        for (int i = 0; i < a - 1; i++) {
            sum += month[i];
        }
        sum += b - 1;
        answer = day[sum % 7];
        return answer;
    }
}
