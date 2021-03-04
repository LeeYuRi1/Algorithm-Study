package programmers;

import java.util.PriorityQueue;

// 더 맵게
public class MoreSpicy {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
        System.out.println(solution(new int[]{0, 0}, 6));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            minHeap.offer(scoville[i]);
        }
        while (minHeap.peek() < K) {
            if (minHeap.size() == 1) return -1;
            minHeap.offer(minHeap.poll() + (minHeap.poll() * 2));
            answer++;
        }
        return answer;
    }
}
