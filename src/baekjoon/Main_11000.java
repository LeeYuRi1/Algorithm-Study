package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11000 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] time = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            time[i][0] = Integer.parseInt(s[0]);
            time[i][1] = Integer.parseInt(s[1]);
        }
        // 시작 시간순으로 오름차순 정렬
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                else return Integer.compare(o1[0], o2[0]);
            }
        });

        // 우선순위큐에 종료시간을 넣어줌
        // 제일 작은 종료시간이 시작시간보다 빨리 끝나거나 같으면 큐에서 빼주고 현재 종료시간 넣어주기
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(time[0][1]);
        for (int i = 1; i < n; i++) {
            if (queue.peek() <= time[i][0]) queue.poll();
            queue.offer(time[i][1]);
        }
        System.out.println(queue.size());
    }
}
