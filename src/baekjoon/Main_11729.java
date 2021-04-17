package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11729 {

    static private StringBuilder sb = new StringBuilder();
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        hanoi(n, 1, 3, 2);
        System.out.println(count);
        System.out.println(sb);
    }

    private static void hanoi(int n, int start, int end, int mid) {
        count++;
        if (n == 1) {
            sb.append(start + " " + end + "\n");
        } else {
            hanoi(n - 1, start, mid, end);
            sb.append(start + " " + end + "\n");
            hanoi(n - 1, mid, end, start);
        }
    }
}
