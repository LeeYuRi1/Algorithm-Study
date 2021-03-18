package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_10866 {

    private static Deque<Integer> deque = new ArrayDeque<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            command(input);
        }
        System.out.println(sb);
    }

    private static void command(String[] s) {
        switch (s[0]) {
            case "push_front":
                deque.addFirst(Integer.parseInt(s[1]));
                break;
            case "push_back":
                deque.addLast(Integer.parseInt(s[1]));
                break;
            case "pop_front":
                if (deque.isEmpty()) sb.append(-1 + "\n");
                else sb.append(deque.pollFirst() + "\n");
                break;
            case "pop_back":
                if (deque.isEmpty()) sb.append(-1 + "\n");
                else sb.append(deque.pollLast() + "\n");
                break;
            case "size":
                sb.append(deque.size() + "\n");
                break;
            case "empty":
                if (deque.isEmpty()) sb.append(1 + "\n");
                else sb.append(0 + "\n");
                break;
            case "front":
                if (deque.isEmpty()) sb.append(-1 + "\n");
                else sb.append(deque.peekFirst() + "\n");
                break;
            case "back":
                if (deque.isEmpty()) sb.append(-1 + "\n");
                else sb.append(deque.peekLast() + "\n");
                break;
        }
    }
}
