package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

// 버블소트를 실제로 사용하면 시간초과. 원리를 알아야함
// 뒤에있는수가 앞으로 오려면 몇 칸 앞으로 와야하는지를 구함 (뒤에 있는 수는 한 칸씩만 앞으로 올 수 있음, 앞에 있는 수는 뒤로 한번에 갈 수 있음)
// 답: 뒤에 있는 수가 앞으로 올 때 인덱스의 차이 중 가장 큰 것 +1
class Number implements Comparable<Number> {
    int index;
    int value;

    Number(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Number o) {
        return this.value - o.value;
    }
}
public class Main_1377 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Number[] a = new Number[n];

        for (int i = 0; i < n; i++) {
            a[i] = new Number(i, sc.nextInt());
        }
        Arrays.sort(a);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (answer < a[i].index - i) {
                answer = a[i].index - i;
            }
        }
        System.out.println(answer+1);
    }

}
