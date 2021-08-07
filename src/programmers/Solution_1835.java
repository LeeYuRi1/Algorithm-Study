package programmers;

import java.util.HashMap;

// 단체사진 찍기
public class Solution_1835 {
    private static HashMap<Character, Integer> map = new HashMap<>();
    private static int[] arr = new int[8];
    private static boolean[] visited = new boolean[8];
    private static int answer;

    public static void main(String[] args) {
        System.out.println(solution(2, new String[]{"N~F=0", "R~T>2"}));
        System.out.println(solution(2, new String[]{"M~C<2", "C~M>1"}));
    }

    public static int solution(int n, String[] data) {
        map.put('A', 0);
        map.put('C', 1);
        map.put('F', 2);
        map.put('J', 3);
        map.put('M', 4);
        map.put('N', 5);
        map.put('R', 6);
        map.put('T', 7);
        answer = 0;
        backtracking(data, 0);
        return answer;
    }

    private static void backtracking(String[] data, int depth) {
        if (depth == 8) {
            check(data);
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                backtracking(data, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void check(String[] data) {
        for (String s : data) {
            int index1 = arr[map.get(s.charAt(0))];
            int index2 = arr[map.get(s.charAt(2))];
            int n = Math.abs(index1 - index2) - 1;
            char op = s.charAt(3);
            int num = Character.getNumericValue(s.charAt(4));
            if (op == '=') {
                if (n != num) return;
            } else if (op == '<') {
                if (n >= num) return;
            } else {
                if (n <= num) return;
            }
        }
        answer++;
    }
}
