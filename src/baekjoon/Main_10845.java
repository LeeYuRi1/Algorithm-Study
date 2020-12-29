package baekjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_10845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        LinkedList queue = new LinkedList();

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            if (line.contains("push")) {
                int num = sc.nextInt();
                queue.add(num);
            } else if (line.equals("pop")) {
                if (queue.isEmpty())
                    sb.append(-1 + "\n");
                else
                    sb.append(queue.removeFirst() + "\n");
            } else if (line.equals("size")) {
                sb.append(queue.size() + "\n");
            } else if (line.equals("empty")) {
                if (queue.isEmpty())
                    sb.append(1 + "\n");
                else
                    sb.append(0 + "\n");
            } else if (line.equals("front")) {
                if (queue.isEmpty())
                    sb.append(-1 + "\n");
                else
                    sb.append(queue.getFirst() + "\n");
            } else if (line.equals("back")) {
                if (queue.isEmpty())
                    sb.append(-1 + "\n");
                else
                    sb.append(queue.getLast() + "\n");
            }
        }

        System.out.println(sb);
    }
}
