package programmers;

import java.util.*;

// 실패율
public class FailureRate {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
        System.out.println(solution(4, new int[]{4, 4, 4, 4, 4}));
        System.out.println(solution(8, new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        LinkedHashMap<Integer, Double> map = new LinkedHashMap<>();

        for (int n = 1; n <= N; n++) {
            int arrival = 0;
            int notClear = 0;
            for (int i = 0; i < stages.length; i++) {
                if (stages[i] >= n) arrival++;
                if (stages[i] == n) notClear++;
            }
            if (arrival > 0) map.put(n, (double) notClear / (double) arrival);
            else map.put(n, 0D);
        }

        List<Map.Entry<Integer, Double>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                } else if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return 1;
                }
            }
        });

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).getKey();
        }
        return answer;
    }
}
