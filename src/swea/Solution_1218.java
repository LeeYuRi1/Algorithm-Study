package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

// 소요 시간 : 104 ms
// 메모리 사용량 : 19,420 kb
public class Solution_1218 {
    private static HashMap<Character, Integer> openMap = new HashMap<>();
    private static HashMap<Character, Integer> closeMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setMap();
        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            char[] chars = br.readLine().toCharArray();
            int ans = check(chars) ? 1 : 0;
            System.out.println("#" + tc + " " + ans);
        }
    }

    private static void setMap() {
        char[][] ps = {{'(', '[', '{', '<'}, {')', ']', '}', '>'}};
        for (int i = 0; i < 4; i++) {
            openMap.put(ps[0][i], i);
            closeMap.put(ps[1][i], i);
        }
    }

    private static boolean check(char[] chars) {
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (openMap.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !openMap.get(stack.peek()).equals(closeMap.get(c))) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
