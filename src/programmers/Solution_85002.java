package programmers;

import java.util.Arrays;

class Pair_85002 implements Comparable<Pair_85002> {
    int num;
    int weight;
    double win;
    int heavyWin;

    public Pair_85002(int num, int weight, double win, int heavyWin) {
        this.num = num;
        this.weight = weight;
        this.win = win;
        this.heavyWin = heavyWin;
    }

    @Override
    public int compareTo(Pair_85002 o) {
        if (o.win != this.win) return Double.compare(o.win, this.win);
        if (o.heavyWin != this.heavyWin) return o.heavyWin - this.heavyWin;
        if (o.weight != this.weight) return o.weight - this.weight;
        return this.num - o.num;
    }
}

// 복서 정렬하기
public class Solution_85002 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{50, 82, 75, 120}, new String[]{"NLWL", "WNLL", "LWNW", "WWLN"})));
        System.out.println(Arrays.toString(solution(new int[]{60, 70, 60}, new String[]{"NNN", "NNN", "NNN"})));
    }

    public static int[] solution(int[] weights, String[] head2head) {
        int len = weights.length;
        Pair_85002[] score = new Pair_85002[len];
        for (int i = 0; i < len; i++) {
            String[] match = head2head[i].split("");
            double fight = 0;
            double win = 0;
            int heavyWin = 0;
            for (int j = 0; j < len; j++) {
                if (!match[j].equals("N")) fight++;
                if (match[j].equals("W")) {
                    if (weights[i] < weights[j]) heavyWin++;
                    win++;
                }
            }
            double per = win / fight * 100;
            if (fight == 0) per = 0;
            score[i] = new Pair_85002(i + 1, weights[i], per, heavyWin);
        }
        Arrays.sort(score);

        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = score[i].num;
        }
        return answer;
    }
}
