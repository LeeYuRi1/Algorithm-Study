package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(s[i]);
            while (!stack.empty()) {
                if (m <= stack.peek()[1]) {
                    sb.append(stack.peek()[0] + " ");
                    stack.push(new int[]{i + 1, m});
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.empty()) {
                stack.push(new int[]{i + 1, m});
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }
}
