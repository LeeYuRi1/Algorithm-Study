package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        int[] num = new int[101];
        for (int i = 0; i < n + m; i++) {
            String[] input2 = br.readLine().split(" ");
            num[Integer.parseInt(input2[0])] = Integer.parseInt(input2[1]);
        }
        System.out.println(move(num));
    }

    private static int move(int[] num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int[] dist = new int[101];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            if (p == 100) return dist[p];
            for (int i = 1; i <= 6; i++) {
                int np = p + i;
                if (np > 100) continue;
                if (num[np] != 0) np = num[np];
                if (dist[np] != -1) continue;
                dist[np] = dist[p] + 1;
                queue.offer(np);
            }
        }
        return dist[100];
    }
}
