package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Pair_14395 {
    long num;
    String op;

    public Pair_14395(long num, String op) {
        this.num = num;
        this.op = op;
    }
}

public class Main_14395 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long s = Long.parseLong(input[0]);
        long t = Long.parseLong(input[1]);
        String ans = "0";
        if (s != t) ans = bfs(s, t);
        System.out.println(ans);
    }

    private static String bfs(long s, long t) {
        Queue<Pair_14395> queue = new LinkedList<>();
        HashSet<Long> set = new HashSet<>();
        queue.offer(new Pair_14395(s, ""));
        set.add(s);
        while (!queue.isEmpty()) {
            Pair_14395 p = queue.poll();
            if (p.num == t) return p.op;
            long d = 0;
            if (p.num != 0) d = p.num / p.num;
            long[] op = {p.num * p.num, p.num + p.num, p.num - p.num, d};
            String[] opString = {"*", "+", "-", "/"};
            for (int i = 0; i < 4; i++) {
                if (i == 3 && p.num == 0) continue;
                long n = op[i];
                if (!set.contains(n)) {
                    set.add(n);
                    queue.offer(new Pair_14395(n, p.op + opString[i]));
                }
            }
        }
        return "-1";
    }
}
