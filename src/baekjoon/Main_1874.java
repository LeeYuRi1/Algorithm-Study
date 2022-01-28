package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (n-- > 0) {
            int target = Integer.parseInt(br.readLine());
            if (target > num) {
                for (int i = num + 1; i <= target; i++) {
                    stack.push(i);
                    sb.append("+\n");
                }
                num = target;
            }
            if (target == stack.peek()) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}