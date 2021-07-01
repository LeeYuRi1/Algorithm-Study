package programmers;

import java.util.ArrayList;

// 키패드 누르기
class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution_67256 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int handL = 10;
        int handR = 11;
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(3, 1));
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                points.add(new Point(x, y));
            }
        }
        points.add(new Point(3, 0));
        points.add(new Point(3, 2));

        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            if (n == 1 || n == 4 || n == 7) {
                answer += "L";
                handL = n;
            } else if (n == 3 || n == 6 || n == 9) {
                answer += "R";
                handR = n;
            } else {
                int sumR = Math.abs(points.get(handR).x - points.get(n).x) + Math.abs(points.get(handR).y - points.get(n).y);
                int sumL = Math.abs(points.get(handL).x - points.get(n).x) + Math.abs(points.get(handL).y - points.get(n).y);

                if (sumR > sumL) {
                    answer += "L";
                    handL = n;
                } else if (sumR == sumL) {
                    if (hand.equals("right")) {
                        answer += "R";
                        handR = n;
                    } else {
                        answer += "L";
                        handL = n;
                    }
                } else {
                    answer += "R";
                    handR = n;
                }
            }
        }
        return answer;
    }
}
