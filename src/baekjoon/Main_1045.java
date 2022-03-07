package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge_1045 {
    int from, to;

    Edge_1045(int from, int to) {
        this.from = from;
        this.to = to;
    }
}

public class Main_1045 {
    private static int N, parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        makeSet();
        Queue<Edge_1045> queue = new LinkedList<>();
        int[] num = new int[N];
        int count = 0;
        // i < j일 때를 검사
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = i + 1; j < N; j++) {
                if (input[j].equals("N")) continue;
                if (union(i, j)) { //i와 j를 연결할 수 있다면 양 끝점의 개수 더해주고 count++
                    num[i]++;
                    num[j]++;
                    count++;
                } else { // 합칠 수 없다면 (사이클일 때) 저장해둠
                    queue.offer(new Edge_1045(i, j));
                }
            }
        }

        // 간선이 N-1개가 아니면 MST가 될 수 없음
        if (count != N - 1) {
            System.out.println(-1);
            return;
        }

        // 간선이 M개여야 하므로 간선을 추가함
        for (int i = N - 1; i < M; i++) {
            if (queue.isEmpty()) { // 간선을 M만큼 못만들면 -1
                System.out.println(-1);
                return;
            }
            // 양 끝 점의 개수 더해주기
            Edge_1045 e = queue.poll();
            num[e.from]++;
            num[e.to]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : num) sb.append(i).append(" ");
        System.out.println(sb);
    }

    private static void makeSet() {
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    private static int findSet(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findSet(parent[x]);
    }

    private static boolean union(int x, int y) {
        int rx = findSet(x);
        int ry = findSet(y);
        if (rx == ry) return false;
        parent[ry] = rx;
        return true;
    }
}
