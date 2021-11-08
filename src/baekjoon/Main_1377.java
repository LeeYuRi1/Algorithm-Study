package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 버블소트를 실제로 사용하면 시간초과. 원리를 알아야함
// 뒤에있는수가 앞으로 오려면 몇 칸 앞으로 와야하는지를 구함 (뒤에 있는 수는 한 칸씩만 앞으로 올 수 있음, 앞에 있는 수는 뒤로 한번에 갈 수 있음)
// 답: 뒤에 있는 수가 앞으로 올 때 인덱스의 차이 중 가장 큰 것 +1
class Pair_1377 implements Comparable<Pair_1377> {
    int index;
    int num;

    Pair_1377(int index, int num) {
        this.index = index;
        this.num = num;
    }

    @Override
    public int compareTo(Pair_1377 o) {
        return this.num - o.num;
    }
}

public class Main_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair_1377[] a = new Pair_1377[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Pair_1377(i, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(a);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, a[i].index - i);
        }
        System.out.println(answer + 1);
    }
}
