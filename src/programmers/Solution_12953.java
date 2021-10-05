package programmers;

import java.util.Stack;

// N개의 최소공배수
public class Solution_12953 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 6, 8, 14}));
    }

    public static int solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            stack.push(a * b / gcd(a, b));
        }
        return stack.pop();
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
