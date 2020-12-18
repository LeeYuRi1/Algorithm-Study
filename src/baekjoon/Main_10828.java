package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            if (line.contains("push")) {
                int num = sc.nextInt();
                stack.push(num);
            } else if (line.equals("pop")) {
                if (stack.empty())
                    sb.append(-1 + "\n");
                else
                    sb.append(stack.pop() + "\n");
            } else if (line.equals("size")) {
                sb.append(stack.size() + "\n");
            } else if (line.equals("empty")) {
                if (stack.empty())
                    sb.append(1 + "\n");
                else {
                    sb.append(0 + "\n");
                }
            } else if (line.equals("top")) {
                if (stack.empty())
                    sb.append(-1 + "\n");
                else {
                    sb.append(stack.peek() + "\n");
                }
            }
        }
        System.out.print(sb);
    }


}
