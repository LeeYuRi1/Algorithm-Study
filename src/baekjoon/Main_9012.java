package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            String input = sc.next();
            String vps = "YES";
            Stack stack = new Stack<>();

            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '(') {
                    stack.push(input.charAt(j));
                } else if (input.charAt(j) == ')') {
                    if (stack.empty()) {
                        vps = "NO";
                        break;
                    } else {
                        stack.pop();
                    }

                }
            }
            if (!stack.empty()) {
                vps = "NO";
            }
            System.out.println(vps);
        }

    }
}