package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4949 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals(".")) return;
            System.out.println(findBalance(input));
        }
    }

    private static String findBalance(String s) {
        Stack<Character> stack = new Stack<>();
        String result = "yes";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[') stack.push(c);
            else if (c == ')' || c == ']') {
                if (stack.isEmpty()) {
                    result = "no";
                    break;
                } else if (c == ')') {
                    if (stack.peek() == '(') stack.pop();
                    else result = "no";
                } else {
                    if (stack.peek() == '[') stack.pop();
                    else result = "no";
                }
            }
        }
        if (result.equals("yes") && !stack.empty()) result = "no";
        return result;
    }
}
