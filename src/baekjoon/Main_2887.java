package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge_2887 implements Comparable<Edge_2887> {
    int from, to, cost;

    Edge_2887(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_2887 o) {
        return this.cost - o.cost;
    }
}

public class Main_2887 {
    private static int N, parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] points = new int[N][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = i; // 정렬할 때 인덱스 바뀌니까 정점 번호 저장
            for (int j = 1; j < 4; j++) {
                points[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Edge_2887> edgeList = new ArrayList<>();
        // 모든 쌍 구하면 시간 초과
        // 각 좌표(x, y, z)에 대해 정렬 후 비용 구하기
        for (int i = 1; i < 4; i++) {
            int point = i; // 람다 표현식에는 final 변수나 변수의 재할당이 발생하지 않는 변수만 사용할 수 있음
            Arrays.sort(points, (o1, o2) -> o1[point] - o2[point]);
            for (int j = 0; j < N - 1; j++) {
                int cost = Math.abs(points[j][i] - points[j + 1][i]);
                edgeList.add(new Edge_2887(points[j][0], points[j + 1][0], cost));
            }
        }

        // 크루스칼
        Collections.sort(edgeList);
        makeSet();
        int ans = 0, count = 0;
        for (Edge_2887 e : edgeList) {
            if (union(e.from, e.to)) {
                ans += e.cost;
                if (++count == N - 1) break;
            }
        }
        System.out.println(ans);
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
