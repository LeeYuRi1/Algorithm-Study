package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split("");
        int n = Integer.parseInt(input1[0]);
        int k = Integer.parseInt(input1[1]);
        int count = 0; // 지운 숫자 개수
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input2.length; i++) {
            int num = Integer.parseInt(input2[i]);
            // 숫자를 지울 수 있고 앞자리 숫자(peek)가 현재 숫자보다 작으면 지움
            while (!stack.isEmpty() && count < k && stack.peek() < num) {
                stack.pop();
                count++;
            }
            stack.push(num);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb.reverse().toString().substring(0, n - k));
    }
}
