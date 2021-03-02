package programmers.level2;

import java.util.*;

// 프린터
class Doc {
    public int index;
    public int doc;

    public Doc(int index, int doc) {
        this.index = index;
        this.doc = doc;
    }
}

public class Printer {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 3));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
        System.out.println(solution(new int[]{3}, 0));
        System.out.println(solution(new int[]{3, 3, 4, 2}, 3));
    }

    static public int solution(int[] priorities, int location) {
        if (priorities.length == 1) return 1;
        int answer = 0;
        Queue<Doc> queue = new LinkedList<>();
        Queue<Integer> sortPriorities = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Doc(i, priorities[i]));
        }
        Arrays.sort(priorities);
        for (int i = priorities.length - 1; i >= 0; i--) {
            sortPriorities.offer(priorities[i]);
        }

        while (!queue.isEmpty()) {
            Doc poll = queue.poll();
            if (poll.doc == sortPriorities.peek()) {
                answer++;
                sortPriorities.poll();
                if (poll.index == location) break;
            } else {
                queue.offer(poll);
            }
        }
        return answer;
    }
}
