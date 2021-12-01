package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Pair_1931 implements Comparable<Pair_1931> {
    int start;
    int end;

    public Pair_1931(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Pair_1931 o) {
        if (this.end == o.end) return this.start - o.start;
        return this.end - o.end;
    }
}

public class Main_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair_1931[] meeting = new Pair_1931[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            meeting[i] = new Pair_1931(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
        Arrays.sort(meeting);
        int time = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (meeting[i].start >= time) {
                ans++;
                time = meeting[i].end;
            }
        }
        System.out.println(ans);
    }
}
