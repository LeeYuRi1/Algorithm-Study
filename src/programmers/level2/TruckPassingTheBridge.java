package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

// 다리를 지나는 트럭
public class TruckPassingTheBridge {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int[]{10}));
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }

    static public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridge_weight = 0;
        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            truck.offer(truck_weights[i]);
        }
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (!truck.isEmpty()) {
            int bp = bridge.poll();
            if (bp != 0) bridge_weight -= bp;

            if ((bridge_weight + truck.peek()) <= weight) {
                int tp = truck.poll();
                bridge_weight += tp;
                bridge.offer(tp);
            } else {
                bridge.offer(0);
            }
            answer++;
        }

        return answer + bridge_length;
    }
}
