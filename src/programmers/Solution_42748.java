package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// K번째수
public class Solution_42748 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(solution(array, commands));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> newArray;
        for (int i = 0; i < commands.length; i++) {
            newArray = new ArrayList<>();
            for (int j = commands[i][0]; j <= commands[i][1]; j++) {
                newArray.add(array[j - 1]);
            }
            Collections.sort(newArray);
            answer[i] = newArray.get(commands[i][2] - 1);
        }
        return answer;
    }
}
