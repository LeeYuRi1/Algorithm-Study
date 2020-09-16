package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1406 {

    static Stack stackL = new Stack<>();
    static Stack stackR = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < input.length(); i++) {
            stackL.push(input.charAt(i));
        }

        for (int i = 0; i < num; i++) {
            String cmd = br.readLine();
            instruction(cmd);
        }

        for (int i = 0; i < stackL.size(); i++)
            System.out.print(stackL.get(i));

        for (int i = stackR.size() - 1; i >= 0; i--)
            System.out.print(stackR.get(i));
    }

    private static void instruction(String cmd) {
        switch (cmd.charAt(0)) {
            case 'L':
                if (!stackL.isEmpty()) stackR.push(stackL.pop());
                break;
            case 'D':
                if (!stackR.isEmpty()) stackL.push(stackR.pop());
                break;
            case 'B':
                if (!stackL.isEmpty()) stackL.pop();
                break;
            case 'P':
                stackL.push(cmd.charAt(2));
                break;
        }
    }

}
