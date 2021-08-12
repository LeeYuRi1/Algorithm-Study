package programmers;

import java.util.Stack;

// 괄호 회전하기
public class Solution_76502 {
    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
    }

    public static int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (check(s)) answer++;
            s = s.substring(1) + s.charAt(0);
        }
        return answer;
    }

    private static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (c == ']' && stack.peek() == '[') stack.pop();
                else if (c == '}' && stack.peek() == '{') stack.pop();
                else if (c == ')' && stack.peek() == '(') stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
