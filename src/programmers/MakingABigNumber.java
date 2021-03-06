package programmers;

// 큰 수 만들기
public class MakingABigNumber {
    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
        System.out.println(solution("111119", 3));
    }

    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        char max;
        int index = 0;
        if (number.charAt(0) == '0') return "0";
        for (int i = 0; i < number.length() - k; i++) {
            max = '0';
            for (int j = index; j <= i + k; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    index = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}