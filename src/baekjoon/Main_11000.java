package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class ClassTime implements Comparable<ClassTime> {
    int start;
    int end;

    public ClassTime(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(ClassTime o) {
        if (this.start == o.start) return this.end - o.end;
        else return this.start - o.start;
    }
}

public class Main_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ClassTime[] classTimes = new ClassTime[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            classTimes[i] = new ClassTime(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
        // 시작 시간순으로 오름차순 정렬
        Arrays.sort(classTimes);
        // 우선순위큐에 종료시간을 넣어줌
        // 제일 작은 종료시간이 시작시간보다 빨리 끝나거나 같으면 큐에서 빼주고 현재 종료시간 넣어주기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (!pq.isEmpty() && pq.peek() <= classTimes[i].start) pq.poll();
            pq.offer(classTimes[i].end);
        }
        System.out.println(pq.size());
    }
}
