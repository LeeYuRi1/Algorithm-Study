package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue queue = new LinkedList();

        for (int i = 1; i < n + 1; i++) {
            queue.add(i);
        }

        System.out.print("<");
        int count = 1;
        while (!queue.isEmpty()) {
            if (count == k) {
                System.out.print(queue.remove());
                count = 1;
                if (queue.size() > 0)
                    System.out.print(", ");

            } else {
                queue.add(queue.remove());
                count++;
            }
        }
        System.out.print(">");
    }
}
