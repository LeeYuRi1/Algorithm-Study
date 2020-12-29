package baekjoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//최대힙
public class Main_11279 {
    static class Compare implements Comparator<Integer> {
        public int compare(Integer one, Integer two) {
            return two.compareTo(one);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Compare cmp = new Compare();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(1, cmp);
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
