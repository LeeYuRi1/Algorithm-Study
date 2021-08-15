package programmers;

// 상호 평가
public class Solution_83201 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67}, {61, 57, 100, 80, 65}, {24, 90, 94, 75, 65}}));
    }

    public static String solution(int[][] scores) {
        String answer = "";
        for (int j = 0; j < scores[0].length; j++) {
            int max = 0;
            int min = 100;
            int same = 0;
            float score = 0;
            // 최고점, 최저점 구하기
            for (int i = 0; i < scores.length; i++) {
                max = Math.max(max, scores[i][j]);
                min = Math.min(min, scores[i][j]);
                score += scores[i][j];
                if (scores[i][j] == scores[j][j]) same++;
            }
            // 자기 자신을 평가한 점수가 유일한 최고점이나 최저점이면
            if ((scores[j][j] == max || scores[j][j] == min) && same == 1) {
                score -= scores[j][j];
                score /= (scores.length - 1);
            } else {
                score /= scores.length;
            }
            // 학점 부여
            answer += grade(score);
        }
        return answer;
    }

    private static String grade(float score) {
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 50) return "D";
        return "F";
    }
}
