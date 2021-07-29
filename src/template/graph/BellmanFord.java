package template.graph;

import java.util.ArrayList;
import java.util.Arrays;

// 벨만포드 (예제 설명: 백준 11657)
// 시간복잡도: O(VE)
// 가중치가 [음수]인 경우에도 사용할 수 있음, 음수 사이클 검사 가능
// n-1번 반복한 후 한번 더 진행했을 때 변경된다면 음수사이클이 존재
class Pair_BellmanFord {
    int start;
    int end;
    int time;

    public Pair_BellmanFord(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}

public class BellmanFord {
    public static void main(String[] args) {
        int n = 3; // 정점 개수
        int m = 4; // 간선 개수
        ArrayList<Pair_BellmanFord> g = new ArrayList<>(); // 인접 행렬, 인접 리스트 사용하지 않음
        g.add(new Pair_BellmanFord(1, 2, 4));
        g.add(new Pair_BellmanFord(1, 3, 3));
        g.add(new Pair_BellmanFord(2, 3, -1));
        g.add(new Pair_BellmanFord(3, 1, -2));

        long[] d = new long[n + 1]; // 최단거리를 저장하는 배열
        int inf = Integer.MAX_VALUE;
        Arrays.fill(d, inf); // dist를 무한대로 초기화
        d[1] = 0; // 1번에서 시작하므로 0 넣어줌

        boolean negativeCycle = false; // 음수사이클인지 확인
        // 정점마다 모든 간선을 한번씩 검사
        for (int i = 1; i <= n; i++) { // 원래는 < n 까지만 검사하지만 음수사이클 존재여부를 확인하기 위해 n까지 검사
            for (int j = 0; j < m; j++) {
                int start = g.get(j).start;
                int end = g.get(j).end;
                int time = g.get(j).time;
                if (d[start] == inf) continue; // 시작점이 무한대이면 아직 최단경로를 구하지 않았으므로 넘어감
                if (d[end] <= d[start] + time) continue; // start+time이 더 크다면 최단거리가 아니므로 넘어감
                d[end] = d[start] + time;
                if (i == n) negativeCycle = true; // i가 n인 경우에도 값이 변경되었으므로 음수사이클(최단경로가 존재하지 않음)
            }
        }

        // 음수사이클이 있다면 -1을 출력하고 아니면 도시마다 최단경로 출력
        if (negativeCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= n; i++) {
                if (d[i] == inf) d[i] = -1;
                System.out.println(d[i]);
            }
        }
    }
}
