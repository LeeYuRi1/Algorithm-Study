package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14888 {
    private static int[] num;
    private static int[] op;
    private static int[] arr;
    private static boolean[] visited;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        num = new int[n];
        op = new int[n - 1];
        arr = new int[n - 1];
        visited = new boolean[n - 1];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(input1[i]);
        }
        int opIndex = 0;
        for (int i = 0; i < 4; i++) {
            int count = Integer.parseInt(input2[i]);
            while (count-- > 0) {
                op[opIndex] = i;
                opIndex++;
            }
        }
        selectOperator(0, n - 1);
        System.out.println(max + "\n" + min);
    }

    private static void selectOperator(int depth, int n) {
        if (depth == n) {
            calculation();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = op[i];
                selectOperator(depth + 1, n);
                visited[i] = false;
            }
        }
    }

    private static void calculation() {
        int result = num[0];
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            if (n == 0) result += num[i + 1];
            else if (n == 1) result -= num[i + 1];
            else if (n == 2) result *= num[i + 1];
            else result /= num[i + 1];
        }
        max = Math.max(max, result);
        min = Math.min(min, result);
    }
}
