package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair_1939 {
    int next;
    int w;

    public Pair_1939(int next, int w) {
        this.next = next;
        this.w = w;
    }
}

public class Main_1939 {
    private static List<Pair_1939>[] bridge;
    private static int n, start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        bridge = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            bridge[i] = new ArrayList<>();
        }
        int max = 0;
        while (m-- > 0) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            int c = Integer.parseInt(input2[2]);
            bridge[a].add(new Pair_1939(b, c));
            bridge[b].add(new Pair_1939(a, c));
            max = Math.max(max, c);
        }
        String[] input3 = br.readLine().split(" ");
        start = Integer.parseInt(input3[0]);
        end = Integer.parseInt(input3[1]);
        System.out.println(find(max));
    }

    // w의 최대값 구하기
    // w가 가능하면 w를 증가시키고, w가 불가능하면 w를 감소시킴
    private static int find(int maxW) {
        int min = 1, max = maxW, mid;
        while (min <= max) {
            mid = (min + max) / 2;
            if (bfs(mid)) min = mid + 1;
            else max = mid - 1;
        }
        return max;
    }

    private static boolean bfs(int w) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            if (p == end) return true;
            for (Pair_1939 pair : bridge[p]) {
                if (visited[pair.next] || pair.w < w) continue;
                queue.offer(pair.next);
                visited[pair.next] = true;
            }
        }
        return false;
    }
}
