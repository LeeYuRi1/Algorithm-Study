package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pair_1647 implements Comparable<Pair_1647> {
    int start;
    int end;
    int cost;

    public Pair_1647(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Pair_1647 o) {
        return this.cost - o.cost;
    }
}

public class Main_1647 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        List<Pair_1647> pairList = new ArrayList<>();
        while (m-- > 0) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            int c = Integer.parseInt(input2[2]);
            pairList.add(new Pair_1647(a, b, c));
        }
        Collections.sort(pairList);
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int ans = 0;
        int max = 0;
        // 크루스칼 알고리즘 사용
        for (int i = 0; i < pairList.size(); i++) {
            Pair_1647 p = pairList.get(i);
            if (find(p.start) == find(p.end)) continue;
            union(p.start, p.end);
            ans += p.cost;
            max = p.cost;
        }
        System.out.println(ans - max);
    }

    // union-find: 여러 노드가 존재할 때, 두개의 노드가 같은 집합에 있는지 확인하는 알고리즘
    // find: x가 어떤 집합에 포함되어 있는지 찾음
    private static int find(int x) {
        if (x == parent[x]) return x;
        parent[x] = find(parent[x]); // 재귀로 집합의 root 노드를 찾음
        return parent[x];
    }

    // union: x와 y가 포함되어 있는 집합을 합침
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }
}
