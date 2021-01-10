package baekjoon;

import java.util.Scanner;

// d[n] = n을 1로 만드는데 필요한 연산의 최소값
// 1. n을 3으로 나누었을 때 1로 만드는데 필요한 연산 횟수: d[n/3] + 1
// 2. n을 2으로 나누었을 때 1로 만드는데 필요한 연산 횟수: d[n/2] + 1
// 3. n을 1로 뺄 때 1로 만드는데 필요한 연산 횟수: d[n-1] + 1
// d[n] = min(1, 2, 3)
public class Main_1463 {
    private static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n+1];
        System.out.println(go(n));

        for (int i:d) {
            System.out.print(i);
        }
    }

    //시간복잡도: O(N) = N(채워야하는 d 배열의 칸의 개수) * O(1)(한칸을 채우기 위한 복잡도)
    private static int go(int n) {
        if (n == 1) return 0;
        if (d[n] > 0) return d[n];
        //n => n-1
        d[n] = go(n - 1) + 1;
        //n => n/2
        if (n % 2 == 0) {
            int temp = go(n / 2) + 1;
            if (d[n] > temp) d[n] = temp;
        }
        //n => n/3
        if (n % 3 == 0) {
            int temp = go(n / 3) + 1;
            if (d[n] > temp) d[n] = temp;
        }
        return d[n];
    }
}
