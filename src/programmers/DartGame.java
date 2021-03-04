package programmers;

// 다트 게임
public class DartGame {
    public static void main(String[] args) {
        System.out.println(solution("1D2S3T*"));
    }

    public static int solution(String dartResult) {
        int answer = 0;
        int[] count = new int[3];
        String num = "";
        int j = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (Character.isDigit(c)) {
                num += c;
            } else if (Character.isLetter(c)) {
                int n = Integer.parseInt(num);
                switch (c) {
                    case 'S':
                        break;
                    case 'D':
                        n = (int) Math.pow(n, 2);
                        break;
                    case 'T':
                        n = (int) Math.pow(n, 3);
                        break;
                }
                count[j] = n;
                num = "";
                j++;
            } else {
                switch (c) {
                    case '*':
                        if (j == 1) count[j - 1] *= 2;
                        else {
                            count[j - 1] *= 2;
                            count[j - 2] *= 2;
                        }
                        break;
                    case '#':
                        count[j - 1] *= -1;
                        break;
                }
            }
        }

        for (int i = 0; i < count.length; i++) {
            answer += count[i];
        }
        return answer;
    }
}
