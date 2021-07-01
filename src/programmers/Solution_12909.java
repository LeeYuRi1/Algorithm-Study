package programmers;

import java.util.Stack;

// 올바른 괄호
public class Solution_12909 {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }

    private static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    stack.push(c);
                    break;
                }
                if (stack.peek() == '(') stack.pop();
            }
        }
        if (stack.empty()) answer = true;
        else answer = false;
        return answer;
    }
}
