package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

//최소힙
public class Main_1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(); // 가장 작은 것부터 순차적으로 나옴
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            int input = sc.nextInt();
            if (input == 0) {
                if (queue.isEmpty()) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(queue.remove() + "\n");
                }
            } else {
                queue.offer(input);
            }
        }
        System.out.println(sb);
    }
}
