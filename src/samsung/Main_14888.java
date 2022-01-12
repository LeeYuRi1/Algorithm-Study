package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_14888 {
    private static int n, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    private static int[] num;
    private static boolean[] visited;
    private static List<Integer> op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(input1[i]);
        }
        op = new ArrayList<>();
        for (int i = 0; i < input2.length; i++) {
            for (int j = 0; j < Integer.parseInt(input2[i]); j++) {
                op.add(i);
            }
        }
        visited = new boolean[n - 1];
        findOperators(0, num[0]);
        System.out.println(max + "\n" + min);
    }

    private static void findOperators(int depth, int result) {
        if (depth == n - 1) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }
        for (int i = 0; i < op.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                findOperators(depth + 1, calculate(op.get(i), result, num[depth + 1]));
                visited[i] = false;
            }
        }
    }

    private static int calculate(int oper, int result, int number) {
        if (oper == 0) return result + number;
        else if (oper == 1) return result - number;
        else if (oper == 2) return result * number;
        else return result / number;
    }
}
