package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            String s = input.charAt(i) + "";
            switch (s) {
                case "(":
                case "[":
                    stack.push(s);
                    break;
                case ")":
                    if (stack.isEmpty() || (!stack.isEmpty() && stack.peek().equals("["))) {
                        System.out.println(0);
                        return;
                    } else if (stack.peek().equals("(")) {
                        stack.pop();
                        stack.push(2 + "");
                    } else {
                        int temp = Integer.parseInt(stack.pop());
                        if (!stack.empty() && stack.peek().equals("(")) {
                            stack.pop();
                            stack.push((temp * 2) + "");
                        } else {
                            System.out.println(0);
                            return;
                        }
                    }
                    break;
                case "]":
                    if (stack.isEmpty() || (!stack.isEmpty() && stack.peek().equals("("))) {
                        System.out.println(0);
                        return;
                    } else if (stack.peek().equals("[")) {
                        stack.pop();
                        stack.push(3 + "");
                    } else {
                        int temp = Integer.parseInt(stack.pop());
                        if (!stack.empty() && stack.peek().equals("[")) {
                            stack.pop();
                            stack.push((temp * 3) + "");
                        } else {
                            System.out.println(0);
                            return;
                        }
                    }
                    break;
            }
            int temp = 0;
            while (!stack.empty() && !stack.peek().equals("(") && !stack.peek().equals("[")) {
                temp += Integer.parseInt(stack.pop());
            }
            if (temp != 0) stack.push(temp + "");
        }
        int ans = 0;
        while (!stack.empty()) {
            String s = stack.peek();
            if (s.equals("(") || s.equals(")") || s.equals("[") || s.equals("]")) {
                System.out.println(0);
                return;
            }
            ans += Integer.parseInt(stack.pop());
        }
        System.out.println(ans);
    }
}
