package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        Stack stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(')
                stack.push(i);
            else {
                if (input.charAt(i-1) == '('){
                    stack.pop();
                    result += stack.size();
                }else {
                    stack.pop();
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}
