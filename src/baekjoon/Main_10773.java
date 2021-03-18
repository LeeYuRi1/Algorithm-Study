package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) stack.pop();
            else stack.push(num);
        }

        int sum = 0;
        while (!stack.empty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
